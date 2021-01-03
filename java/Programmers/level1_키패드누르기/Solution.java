class Solution {
    public String solution(int[] numbers, String hand) {
        String result = "";
        int left=10;
        int right=12;

        for (int i=0;i<numbers.length;i++){
            if (numbers[i] ==1 || numbers[i] ==4 || numbers[i] == 7){
                result+="L";
                left=numbers[i];
            } else if(numbers[i] ==3 || numbers[i] ==6 || numbers[i] == 9){
                result+="R";
                right=numbers[i];
            } else{ // 가운데
                int distL=distanceCal(left,numbers[i]);
                int distR=distanceCal(right,numbers[i]);

                if (distL > distR){ // 거리가 더 큰값이 먼곳임.
                    result+="R";
                    right=numbers[i];
                }else if(distL < distR){
                    result+="L";
                    left=numbers[i];
                } else{
                    if (hand.equals("right")){
                        result+='R';
                        right=numbers[i];
                    } else{
                        result+="L";
                        left=numbers[i];
                    }
                }
            }  
        }
        return result;
    }

    public static int distanceCal(int location, int num) {
        // 키패드 0 처리
        if (location == 0) {
            location = 11;
        }
        if (num == 0) {
            num = 11;
        }
        int locationX = (location - 1) / 3; // x좌표
        int locationY = (location - 1) % 3;
        int targetX=(num-1)/3;
        int targetY=(num-1)%3;

        int cal=Math.abs(locationX-targetX) + Math.abs(locationY-targetY);

        return cal;
    }
}
