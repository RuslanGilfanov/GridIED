import java.security.SecureRandom;
import java.util.Scanner;

public class GameGrid{

    public static void run() {

        LinkedList oLinkedList = new LinkedList();

        int[][] aiGrid = new int[10][10];
        SecureRandom oRand = new SecureRandom();

        int iIEDChance = 20; // ****
        int iRow;
        int iCol;
        int iMoves = 0;

        for (iRow = 0; iRow < aiGrid.length; iRow++) {
            for (iCol = 0; iCol < aiGrid[iRow].length; iCol++) {

                int iRand = oRand.nextInt(100);
                aiGrid[0][0] = 0;
                aiGrid[9][9] = 0;
                if (iRand < iIEDChance) {
                    aiGrid[iRow][iCol] = 1;
                } else {
                    aiGrid[iRow][iCol] = 0;
                }
            }
        }

        do {
            int iUserRow = 0;
            int iUserCol = 0;

            Scanner input = new Scanner(System.in);

            System.out.println("You are - 88A, Transportation Officer attached to 101st Airborne sustainment brigade.\n" +
                    "Your mission is is to transport supply from FOB 'Cobra' to FOB 'Gabe' which" +
                    " is located on South-East side of the Diyala province.\nYou are in charge of the mission and " +
                    "a convoy. Remember that their lives depend on your calls and judgements.\nFOB 'Gabe' is located " +
                    "at grid [9:9]" +
                    "\n\nUse the following options to navigate (Capital letters only)\n\t'E' - East\n\t'W' - West\n\t" +
                    "'N' - North\n\t'S' - South\nChoice: ");


            do {
                char sChoice = input.next().charAt(0);
                int cDeath = 7;
                iMoves++;

                switch (sChoice) {
                    case 'S':
                        if (aiGrid[iUserRow][iUserCol] == 1) {
                            System.out.println("IED detonated at grid " + iUserRow + ":" + iUserCol + "\nMission Failed\n");
                            aiGrid[iUserRow][iUserCol] = cDeath;
                            printGrid(aiGrid);
                            System.out.println("\nYou made " + iMoves+ " moves");
                            System.exit(0);
                        } else if (aiGrid[iUserRow][iUserCol] == 0) {
                            iUserRow++;
                            oLinkedList.addHeadNode(iUserRow, iUserCol);

                            System.out.println("IED has been avoided at grid " + iUserRow + ":" + iUserCol);
                            if(iUserRow == 9 && iUserCol == 9){
                                System.out.println("\nYou escorted convoy through and avoided all IEDs, reached " +
                                        "FOB 'Gabe' and brought your company safe with no casualties.\n");
                                char cFinish = 'F';
                                aiGrid[iUserRow][iUserCol] = cFinish;
                                printGrid(aiGrid);
                                System.out.println(iMoves);
                                System.exit(0);
                            }
                            else if (iUserRow >= 10){
                                System.out.println("You are leaving the area of operation. Get back on the route");
                            }
                        }
                        break;

                    case 'N':
                        if (aiGrid[iUserRow][iUserCol] == 1) {
                            System.out.println("IED detonated at grid " + iUserRow + ":" + iUserCol + "\nMission Failed\n");
                            aiGrid[iUserRow][iUserCol] = cDeath;
                            printGrid(aiGrid);
                            System.out.println("\nYou made " + iMoves+ " moves");
                            System.exit(0);
                        } else if (aiGrid[iUserRow][iUserCol] == 0) {
                            iUserRow--;
                            oLinkedList.addHeadNode(iUserRow, iUserCol);

                            System.out.println("IED has been avoided at grid " + iUserRow + ":" + iUserCol);
                            if(iUserRow == 9 && iUserCol == 9){
                                System.out.println("\nYou escorted convoy through and avoided all IEDs, reached " +
                                        "FOB 'Gabe' and brought your company safe with no casualties.\n");
                                char cFinish = 'F';
                                aiGrid[iUserRow][iUserCol] = cFinish;
                                printGrid(aiGrid);
                                System.out.println("\nYou made " + iMoves+ " moves");
                                System.exit(0);
                            }
                            else if (iUserRow < 0){
                                System.out.println("You are leaving the area of operation. Get back on the route");
                            }
                        }
                        break;
                    case 'W':
                        if (aiGrid[iUserRow][iUserCol] == 1) {
                            System.out.println("IED detonated at grid " + iUserRow + ":" + iUserCol + "\nMission Failed\n");
                            aiGrid[iUserRow][iUserCol] = cDeath;
                            printGrid(aiGrid);
                            System.out.println("\nYou made " + iMoves+ " moves");
                            System.exit(0);
                        } else if (aiGrid[iUserRow][iUserCol] == 0) {
                            iUserCol--;
                            oLinkedList.addHeadNode(iUserRow, iUserCol);

                            System.out.println("IED has been avoided at grid " + iUserRow + ":" + iUserCol);
                            if(iUserRow == 9 && iUserCol == 9){
                                System.out.println("\nYou escorted convoy through and avoided all IEDs, reached " +
                                        "FOB 'Gabe' and brought your company safe with no casualties.\n");
                                char cFinish = 'F';
                                aiGrid[iUserRow][iUserCol] = cFinish;
                                printGrid(aiGrid);
                                System.out.println("\nYou made " + iMoves+ " moves");
                                System.exit(0);
                            }
                            else if (iUserCol < 0){
                                System.out.println("You are leaving the area of operation. Get back on the route");
                            }
                        }
                        break;
                    case 'E':
                        if (aiGrid[iUserRow][iUserCol] == 1) {
                            System.out.println("IED detonated at grid " + iUserRow + ":" + iUserCol + "\nMission Failed\n");
                            aiGrid[iUserRow][iUserCol] = cDeath;
                            printGrid(aiGrid);
                            System.out.println("\nYou made " + iMoves+ " moves");
                            System.exit(0);
                        } else if (aiGrid[iUserRow][iUserCol] == 0) {
                            iUserCol++;
                            oLinkedList.addHeadNode(iUserRow, iUserCol);

                            System.out.println("IED has been avoided at grid " + iUserRow + ":" + iUserCol);
                            if(iUserRow == 9 && iUserCol == 9){
                                System.out.println("\nYou escorted convoy through and avoided all IEDs, reached " +
                                        "FOB 'Gabe' and brought your company safe with no casualties.\n");
                                char cFinish = 'F';
                                aiGrid[iUserRow][iUserCol] = cFinish;
                                while(oLinkedList.headNode != null){
                                    Node oNode1 = oLinkedList.removeHeadNode();
                                    aiGrid[oNode1.xPosition][oNode1.yPosition] = 9;
                                }
                                printGrid(aiGrid);
                                System.out.println("\nYou made " + iMoves+ " moves");
                                System.exit(0);
                            }
                            else if (iUserCol >= 10){
                                System.out.println("You are leaving the area of operation. Get back on the route");
                            }
                        }
                        break;
                }
            } while (true);
        }while(true);
    }

    private static void printGrid(int[][]aiGrid){
        for(int x=0; x < aiGrid.length; x++){ // Gives us the length of the first number (10)
            for( int y=0; y < aiGrid[x].length;y++){ // Going to inner array length.

                System.out.print(" " + aiGrid[x][y]);
            }
            System.out.println();
        }

    }
}