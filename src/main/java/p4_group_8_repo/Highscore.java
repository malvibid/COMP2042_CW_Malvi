package p4_group_8_repo;

import java.io.*;

import static p4_group_8_repo.Controllers.GamePlayController._highscore;
import static p4_group_8_repo.Player.frog;

/**
 * This class handles reading and writing the highest score to a text file.
 */
public class Highscore {

    private FileReader readFile = null;
    private BufferedReader reader = null;

    /**
     * Default constructor of Highscore.
     */
    public Highscore() {
    }

    /**
     * This method reads the input from a text file.
     * @return - File content
     * @throws IOException -
     */
    public String GetHighScore() throws IOException {
        try {
            readFile = new FileReader("highscore.txt");

            reader = new BufferedReader(readFile);
            return reader.readLine();

        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
        finally {
            if(reader != null){
                reader.close();
            }

        }
    }

    /**
     * This method checks the players current score and if it is more than the stored highscore, the highscore will be updated by writing to the text file.
     * It also checks whether a file is already created or not. If a file doesn't exist then a new one will be created.
     */
    public void checkHighScore(){
        System.out.println(_highscore);

        //if highscore is -1 it means its not initiated, hence initiate it.
        if(_highscore.equals("")){
            try {
                _highscore = this.GetHighScore();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(_highscore);

        if (frog.getPoints() > Integer.parseInt(_highscore));
        {
            //user has set a new record.
            _highscore = String.valueOf(frog.getPoints());
        }

        File scoreFile = new File("highscore.txt");
        if(!scoreFile.exists()){
            try {
                scoreFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //FileWriter stores the file we want to write to.
        FileWriter writeFile;

        //BufferedWriter allows us to actually write to the file.
        BufferedWriter writer = null;

        try {
            writeFile = new FileWriter(scoreFile);
            writer = new BufferedWriter(writeFile);
            writer.write(_highscore);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }




}