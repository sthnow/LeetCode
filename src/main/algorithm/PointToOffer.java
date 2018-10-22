public class PointToOffer {

    /**
     * 面试题3：二维数组中的查找
     * @param martix
     * @param rows
     * @param columns
     * @param number
     * @return
     */
    public static boolean find(int[][] martix,int rows,int columns,int number){
        boolean flag = false;

        int row = 0;
        int column = columns - 1;

        if(martix != null && rows > 0 && columns > 0){

            //循环结束的边界
            while(row < rows && column >= 0){

                //如果找到了该数
                if(martix[row][column] == number){
                    flag = true;
                    break;
                }

                //如果没有找到，根据这个二维数组的特点，如果大于目标值，则列数-1
                else if(martix[row][column] > number){
                    column--;
                }

                //如果小于目标值，则行数 +1
                else{
                    row++;
                }
            }

        }
        return flag;
    }
}
