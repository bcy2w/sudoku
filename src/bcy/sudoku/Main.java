package bcy.sudoku;

import java.util.Arrays;
import java.util.List;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static private final Logger LOGGER =
        Logger.getLogger( Main.class.getName() );

    static private final String PROP_FILENAME = "config.properties";

    static private final Pattern SHORTARG_PATTERN =
        Pattern.compile( "\\-(\\p{Alpha})(\\w*)" );

    static private final List<String> CONSOLE_COMMANDS =
        Arrays.asList( "LIST_PORTS" );

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Properties props = loadProperties();

        String loggingProperties =
            (String) props.getProperty( "logging.properties" );
        if ( loggingProperties != null ) {
            System.out.println( "logging properties = " + loggingProperties );
            try {
                LogManager.getLogManager().readConfiguration(
                    new FileInputStream( loggingProperties ) );
            } catch ( Exception e ) {
                LOGGER.log( Level.SEVERE,
                    "Could not load logging properties", e );
            }
        }

        props.setProperty( "command", "RUN_AUTO" );

        processArgs( props, args );

        //
        // Set up the back-end.
        //

        launch( args );
        return;

    }

    @Override
    public void start( Stage stage ) throws IOException {
        Parent root = FXMLLoader.load( getClass().getResource(
            "/bcy/sudoku/ui/MainPage.fxml" ) );
        Scene scene = new Scene( root, 400, 480 );
        stage.setTitle( "Sudoku 2015" );
        stage.setScene( scene );
        stage.show();
    }

    static private Properties loadProperties() {
        Properties defProps = new Properties();
        try {
            defProps.load( new FileInputStream( PROP_FILENAME + ".tmpl" ) );
        } catch ( Exception ex ) {
            LOGGER.log( Level.SEVERE, "Error loading default properties.", ex );
        }

        Properties props = new Properties();
        try {
            props.load( new FileInputStream( PROP_FILENAME ) );
        } catch ( Exception e ) {
            return defProps;
        }
        return props;
    }

    static private void processArgs( Properties props, String[] args ) {

        props.setProperty( "command", "RUN_AUTO" );
        String propKey = null;
        String value = null;
        for ( String arg : args ) {
            if ( arg.startsWith( "-" ) ) {
                Matcher m = SHORTARG_PATTERN.matcher( arg );
                String key = null;
                if ( m.matches() ) {
                    key = m.group(1);
                    value = m.group(2);
                }

                if ( key != null ) {
                    switch ( key ) {
                    case "q" :
                        propKey = "ui";
                        value = "console";
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Argument: " + key + ": " + arg );
                    }
                }
            }

            if ( value != null ) {
                String propValue = null;
                propValue = value;
                props.setProperty( propKey, propValue );
                propKey = null;
                value = null;
            }
        }

    }

}
