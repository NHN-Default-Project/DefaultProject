package org.example.yunhwa.spaceShip;

public class SpaceShip implements Explorer {

    @Override
    public void visit(Mercury mercury) {
        System.out.println("수성에 방문하였습니다.");
    }

    @Override
    public void visit(Venus venus) {
        System.out.println("금성에 방문하였습니다.");
    }

    @Override
    public void visit(Earth earth) {
        System.out.println("지구에 방문하였습니다.");
    }

    @Override
    public void visit(Mars mars) {
        System.out.println("화성에 방문하였습니다.");
    }

    @Override
    public void visit(Jupiter jupiter) {
        System.out.println("목성에 방문하였습니다.");
    }

    @Override
    public void visit(Saturn saturn) {
        System.out.println("토성에 방문하였습니다.");
    }

    @Override
    public void visit(Uranus uranus) {
        System.out.println("천왕성에 방문하였습니다.");
    }

    @Override
    public void visit(Neptune neptune) {
        System.out.println("해왕성에 방문하였습니다.");
    }

}