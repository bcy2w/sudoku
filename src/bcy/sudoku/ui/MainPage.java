package bcy.sudoku.ui;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainPage implements Initializable {

    @FXML public TextField c00;
    @FXML public TextField c01;
    @FXML public TextField c02;
    @FXML public TextField c03;
    @FXML public TextField c04;
    @FXML public TextField c05;
    @FXML public TextField c06;
    @FXML public TextField c07;
    @FXML public TextField c08;
    @FXML public TextField c10;
    @FXML public TextField c11;
    @FXML public TextField c12;
    @FXML public TextField c13;
    @FXML public TextField c14;
    @FXML public TextField c15;
    @FXML public TextField c16;
    @FXML public TextField c17;
    @FXML public TextField c18;
    @FXML public TextField c20;
    @FXML public TextField c21;
    @FXML public TextField c22;
    @FXML public TextField c23;
    @FXML public TextField c24;
    @FXML public TextField c25;
    @FXML public TextField c26;
    @FXML public TextField c27;
    @FXML public TextField c28;
    @FXML public TextField c30;
    @FXML public TextField c31;
    @FXML public TextField c32;
    @FXML public TextField c33;
    @FXML public TextField c34;
    @FXML public TextField c35;
    @FXML public TextField c36;
    @FXML public TextField c37;
    @FXML public TextField c38;
    @FXML public TextField c40;
    @FXML public TextField c41;
    @FXML public TextField c42;
    @FXML public TextField c43;
    @FXML public TextField c44;
    @FXML public TextField c45;
    @FXML public TextField c46;
    @FXML public TextField c47;
    @FXML public TextField c48;
    @FXML public TextField c50;
    @FXML public TextField c51;
    @FXML public TextField c52;
    @FXML public TextField c53;
    @FXML public TextField c54;
    @FXML public TextField c55;
    @FXML public TextField c56;
    @FXML public TextField c57;
    @FXML public TextField c58;
    @FXML public TextField c60;
    @FXML public TextField c61;
    @FXML public TextField c62;
    @FXML public TextField c63;
    @FXML public TextField c64;
    @FXML public TextField c65;
    @FXML public TextField c66;
    @FXML public TextField c67;
    @FXML public TextField c68;
    @FXML public TextField c70;
    @FXML public TextField c71;
    @FXML public TextField c72;
    @FXML public TextField c73;
    @FXML public TextField c74;
    @FXML public TextField c75;
    @FXML public TextField c76;
    @FXML public TextField c77;
    @FXML public TextField c78;
    @FXML public TextField c80;
    @FXML public TextField c81;
    @FXML public TextField c82;
    @FXML public TextField c83;
    @FXML public TextField c84;
    @FXML public TextField c85;
    @FXML public TextField c86;
    @FXML public TextField c87;
    @FXML public TextField c88;

    private TextField[][] cells = new TextField[9][9];

    @Override
    public void initialize( URL url, ResourceBundle rb ) {
        cells[0][0] = c00; cells[0][1] = c01; cells[0][2] = c02;
        cells[0][3] = c03; cells[0][4] = c04; cells[0][5] = c05;
        cells[0][6] = c06; cells[0][7] = c07; cells[0][8] = c08;
        cells[1][0] = c10; cells[1][1] = c11; cells[1][2] = c12;
        cells[1][3] = c13; cells[1][4] = c14; cells[1][5] = c15;
        cells[1][6] = c16; cells[1][7] = c17; cells[1][8] = c18;
        cells[2][0] = c20; cells[2][1] = c21; cells[2][2] = c22;
        cells[2][3] = c23; cells[2][4] = c24; cells[2][5] = c25;
        cells[2][6] = c26; cells[2][7] = c27; cells[2][8] = c28;
        cells[3][0] = c30; cells[3][1] = c31; cells[3][2] = c32;
        cells[3][3] = c33; cells[3][4] = c34; cells[3][5] = c35;
        cells[3][6] = c36; cells[3][7] = c37; cells[3][8] = c38;
        cells[4][0] = c40; cells[4][1] = c41; cells[4][2] = c42;
        cells[4][3] = c43; cells[4][4] = c44; cells[4][5] = c45;
        cells[4][6] = c46; cells[4][7] = c47; cells[4][8] = c48;
        cells[5][0] = c50; cells[5][1] = c51; cells[5][2] = c52;
        cells[5][3] = c53; cells[5][4] = c54; cells[5][5] = c55;
        cells[5][6] = c56; cells[5][7] = c57; cells[5][8] = c58;
        cells[6][0] = c60; cells[6][1] = c61; cells[6][2] = c62;
        cells[6][3] = c63; cells[6][4] = c64; cells[6][5] = c65;
        cells[6][6] = c66; cells[6][7] = c67; cells[6][8] = c68;
        cells[7][0] = c70; cells[7][1] = c71; cells[7][2] = c72;
        cells[7][3] = c73; cells[7][4] = c74; cells[7][5] = c75;
        cells[7][6] = c76; cells[7][7] = c77; cells[7][8] = c78;
        cells[8][0] = c80; cells[8][1] = c81; cells[8][2] = c82;
        cells[8][3] = c83; cells[8][4] = c84; cells[8][5] = c85;
        cells[8][6] = c86; cells[8][7] = c87; cells[8][8] = c88;

        for ( int r = 0; r < 9; r++ ) {
            for ( int c = 0; c < 9; c++ ) {
                cells[r][c].setText( "" + (c+1) );
            }
        }

    }

    @FXML protected void handleExitButton( ActionEvent event ) {
        EventTarget target = event.getTarget();
        if ( target != null && target instanceof Node ) {
            Window window = ((Node)target).getScene().getWindow();
            if ( window instanceof Stage ) {
                ((Stage)window).close();
            } else {
                window.hide();
            }
        }
    }

    private void runTask( Task task ) {
        Thread th = new Thread( task );
        th.setDaemon( true );
        th.start();
    }

}
