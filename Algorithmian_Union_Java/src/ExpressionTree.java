import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by dongdor on 2016. 7. 21..

 */

/*
    자바 Arrays클래스
    impoty java.util.Arrays; 로 불러온다
    1) Arrays.asList(배열) : 배열을 리스트로 바꿔준다
    2) Arrays.binarySearch(배열명,값) : 몇번째 저장되어있는지 확인
    --> 오름차순(1,2,3,4) 정리되어있어야한다.

    3) Arrays.equals(배열,배열) : 배열의 값이 같은지 비교하는 함수
    4) Arrays.sort(배열) : 정열하는 함수
    5) Arrays.fill(배열,채울값) : 채울값으로 초기

 */


public class ExpressionTree {

    private ExpressionNode root;

    public ExpressionNode getRoot(){
        return root;
    }

    public ExpressionTree(String postfixNotation){
        LinkedList<String> tokens = new LinkedList<String>(Arrays.asList(postfixNotation.split(" ")));
                Arrays.asList(postfixNotation.split(""));
        buildExpressionTree(tokens,root);
    }

    public void buildExpressionTree(LinkedList<String> tokens, ExpressionNode node){

        if(tokens.peekLast() == null)
            return;

        //마지막값을 삭제와 동시에 반환
        String tempToken = tokens.removeLast();

        switch(tempToken){
            case "+":
            case "-":
            case "*":
            case "/":
                //노드에 입력된 것이 없고 처음이라면
                if(node == null)
                    node = new ExpressionNode();
                //만들어진 노드에 값을 넣는다
                node.setData(tempToken);
                if(root == null)
                    root = node;
                //노드의 양 날개를 만들어준다.
                node.setRight(new ExpressionNode());
                node.setLeft(new ExpressionNode());
                //오른쪽부터 차근차근 만든다.
                buildExpressionTree(tokens,node.getRight());
                buildExpressionTree(tokens,node.getLeft());
                break;
            //어느것에도 해당되지않으면
            default:
                node.setData(tempToken);
                break;
        }

    }

    public double evaluationTree(ExpressionNode node){
        if(node == null)
            return 0.0;
        double result = 0.0;
        switch(node.getData()){

            case "+" :
                result = evaluationTree(node.getLeft())+evaluationTree(node.getRight());
                break;

            case "-" :
                result = evaluationTree(node.getLeft())-evaluationTree(node.getRight());
                break;

            case "*" :
                result = evaluationTree(node.getLeft())*evaluationTree(node.getRight());
                break;

            case "/" :
                result = evaluationTree(node.getLeft())/evaluationTree(node.getRight());
                break;

            default:
                result = Double.parseDouble(node.getData());
                break;
        }
        return result;
    }

    /*
    전위 순회
     */

    public void preOrderPrintTree(ExpressionNode node){
        if(node == null)
            return;
        System.out.print(node.getData()+" ");
        preOrderPrintTree(node.getLeft());
        preOrderPrintTree(node.getRight());
    }

    /*
    중위 순회
     */
    public void inOrderPrintTree(ExpressionNode node){
        if(node == null)
            return;
        inOrderPrintTree(node.getLeft());
        System.out.print(node.getData()+" ");
        inOrderPrintTree(node.getRight());
    }

    /*
    후위 순회
    */
    public void postOrderPrintTree(ExpressionNode node){
        if(node == null)
            return;
        postOrderPrintTree(node.getLeft());
        postOrderPrintTree(node.getRight());
        System.out.print(node.getData()+"");
    }

    class ExpressionNode{
        private String data;
        private ExpressionNode left;
        private ExpressionNode right;

        public ExpressionNode(){

        }

        public ExpressionNode(String data){
            this.data = data;
        }

        public String getData(){
            return data;
        }

        public void setData(String data){
            this.data = data;
        }

        public ExpressionNode getLeft(){
            return left;
        }

        public void setLeft(ExpressionNode left){
            this.left = left;
        }

        public ExpressionNode getRight(){
            return right;
        }

        public void setRight(ExpressionNode right){
            this.right = right;
        }
    }
}



























