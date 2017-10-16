/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package tma1_q2;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
//import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Jack
 */
public class TMA1_Q2 extends Application {
    private Scene scene;
//    private ScrollPane scrollPane;
    private GridPane grid;
    public int[][] ia = new int[4][4];
    private static final double BUTTONS_PER_LINE = 4;
    private static final double NUM_BUTTON_LINES = 4;
    private static final double BUTTON_PADDING   = 5;
    private static final int SCENE_WIDTH = 150;
    private static final int SCENE_HEIGHT = 150;
    
    private int player = 1;
    int scores;
    
    @Override
    public void start(Stage primaryStage) {
        setupBoard();  //this version always 4x4 board
        primaryStage.setTitle("Hello World!");
        // primaryStage.setScene(new Scene(this.scrollPane));
        primaryStage.setScene(this.scene);
        primaryStage.show();
    }
    
    public void setupBoard(){
        grid = new GridPane();
        grid.setPadding(new Insets(BUTTON_PADDING));
        grid.setHgap(BUTTON_PADDING);
        grid.setVgap(BUTTON_PADDING);
        
        for (int r = 0; r < NUM_BUTTON_LINES; r++) {
            for (int c = 0; c < BUTTONS_PER_LINE; c++) {
                final int row = r;
                final int col = c;
                Button button = new Button();
                button.setMinWidth(30);
                button.setMinHeight(30);
                button.setOnAction((ActionEvent e) -> {
                    placeSymbol(row,col);
                    boolean isWin = checkWin(row,col);
                    if(!isWin){
                        switchPlayer();
                        //continue
                    }else{
                        //exit the program... not making tie game
                        System.exit(0);
                    }
                });
                
                grid.add(button, c, r);
            }
        }
        // this.scrollPane = new ScrollPane(grid);
        this.scene = new Scene(grid, SCENE_WIDTH, SCENE_HEIGHT);
    }
    
    public void placeSymbol(int r, int c){
        Node node = this.getNodeByRowColumnIndex(r, c, grid);
        final Button button = (Button) node;
        if(this.getPlayer() == 1){
            button.setText("X");
        }else if(this.getPlayer() == 2){
            button.setText("O");
        }
        ia[r][c] = this.getPlayer();
        
    }
    
    public boolean checkWin(int r, int c){  //find winner, if found return true otherwise return false
        System.out.println(r + " : " + c);
        
        int result = checkScores(r,c,this.getPlayer());
        System.out.println("Player " + this.getPlayer() +  " Scores: " + result);
        if(result >= 3){
            showMessage("Player " + this.getPlayer() + ", You Win. Program will exit.");
            return true;
        }else{
            return false;
        }
    }
    
    public int checkScores(int r, int c, int player){
        
        // ia[r][c] current location alwatys player 1 so score = 1
        scores = 1;
        boolean up_break = false;
        boolean down_break = false;
        boolean left_break = false;
        boolean right_break = false;
        
        boolean ld_break = false;
        boolean ru_break = false;
        boolean lu_break = false;
        boolean rd_break = false;
        
        int up_s = 0;
        int down_s = 0;
        int left_s = 0;
        int right_s = 0;
        int left_down_s = 0;
        int right_up_s = 0;
        int left_up_s = 0;
        int right_down_s = 0;
        
        for(int cr = 1; cr<=2; cr++){
            //row affect Y  and col affect X   * array not up+ down-
            //上
            try{
                if(!up_break){
                    if(player == ia[r-cr][c]) up_s++; else up_break = true;
                }
            }catch(Exception e){
                
            }
            
            //下
            try{
                if(!down_break){
                    if(player == ia[r+cr][c]) down_s++; else down_break = true;
                }
            }catch(Exception e){
                
            }
            
            //左
            try{
                if(!left_break){
                    if(player == ia[r][c-cr]) left_s++; else left_break = true;
                }
            }catch(Exception e){
                
            }
            
            //右
            try{
                if(!right_break){
                    if(player == ia[r][c+cr]) right_s++; else right_break = true;
                }
            }catch(Exception e){
                
            }
            
            //左上
            try{
                if(!lu_break){
                    if(player == ia[r-cr][c-cr]) left_up_s++; else lu_break = true;
                }
            }catch(Exception e){
                
            }
            
            //左下
            try{
                if(!ld_break){
                    if(player == ia[r+cr][c-cr]) left_down_s++; else ld_break = true;
                }
            }catch(Exception e){
                
            }
            
            //右上 x + 1   y  + 1
            try{
                if(!ru_break){
                    if(player == ia[r-cr][c+cr]) right_up_s++; else ru_break = true;
                }
            }catch(Exception e){
                
            }
            
            //右下  x + 1  y - 1
            try{
                if(!rd_break){
                    if(player == ia[r+cr][c+cr]) right_down_s++; else rd_break = true;
                }
            }catch(Exception e){
                
            }
        }
        
//        System.out.println("up_s: " + up_s);
//        System.out.println("down_s: " + down_s);
//        System.out.println("left_s: " + left_s);
//        System.out.println("right_s: " + right_s);
//        System.out.println("left_down_s: " + left_down_s);
//        System.out.println("right_up_s: " + right_up_s);
//        System.out.println("left_up_s: " + left_up_s);
//        System.out.println("right_down_s: " + right_down_s);
        
        //it means current row and col every direction have 2 match so the scores = 3    scores base is 1 + one direction 2 = 3
        if(2 == up_s || 2 == down_s || 2 == left_s || 2 == right_s || 2 == left_down_s || 2 == right_up_s || 2 == left_up_s || 2 == right_down_s){
            scores = 3;
        }
        return scores;
    }
    
    public void switchPlayer(){
        if(this.getPlayer() == 1){
            this.setPlayer(2);
        }else if(this.getPlayer() == 2){
            this.setPlayer(1);
        }
        showMessage("Player " + this.getPlayer() + ", your turn.");
    }
    
    public void showMessage(String message){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public int getPlayer() {
        return player;
    }
    
    public void setPlayer(int player) {
        this.player = player;
    }
    
    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();
        
        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        
        return result;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
