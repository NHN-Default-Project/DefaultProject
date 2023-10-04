package org.example.yunhwa.spaceShip;

public interface Explorer { // 우주선 한 대 : 각 행성을 탐험하러 다니는 타입
    
    public void visit(Mercury mercury);
    public void visit(Venus venus);
    public void visit(Earth earth);
    public void visit(Mars mars);
    public void visit(Jupiter jupiter);
    public void visit(Saturn saturn);
    public void visit(Uranus uranus);
    public void visit(Neptune neptune);

    default void visit(Planet planet) {
        System.out.println("이름 모를 행성에 착륙하였습니다..");
    }
}

