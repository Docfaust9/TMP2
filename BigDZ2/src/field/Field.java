package field;
public class Field
{
    public int[][] field = new int[8][8];
    boolean[][] bombs = new boolean[8][8];
    public Field()
    {
        for (int i=0; i<8; i++)
        {
            for (int j=0; j<8; j++)
            {
                this.bombs[i][j] = false;
            }
        }
        for (int i=0; i<6; i++)             //заполняем мины на поле
        {
            int x = (int) (Math.random()*7);
            int y = (int) (Math.random()*7);
            this.bombs[x][y] = true;
        }

        for (int i=0; i<8; i++)            //заполняем клетки цифрами
        {
            for (int j = 0; j < 8; j++)
            {

                if(this.bombs[i][j])
                {
                    this.field[i][j] = -1;
                }
                else
                {
                    int counter = 0;
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {
                            if ((i + x >= 0) && (j + y >= 0)&&(i + x <= 7) && (j + y <= 7))
                            {
                                if (this.bombs[i+x][j+y])
                                {
                                    counter++;
                                }
                            }
                        }
                    }
                    this.field[i][j] = counter;
                }


            }
        }
    }

}
