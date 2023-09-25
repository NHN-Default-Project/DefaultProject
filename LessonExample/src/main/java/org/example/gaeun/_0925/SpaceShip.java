package org.example.gaeun._0925;

public class SpaceShip {
    public void visit(Planet planet){
        planet.visit();
    }
}
class Planet extends SpaceShip{
    public void visit() {
    }
}
class Mercury extends Planet {

    @Override
    public void visit() {
        System.out.println("수성에 방문했습니다.");
    }

}
//오버라이딩
//행성마다 방문하는 방법이 다름
class Venus extends Planet {
    @Override
    public void visit() {
        System.out.println("금성에 방문했습니다. ");
    }
}

