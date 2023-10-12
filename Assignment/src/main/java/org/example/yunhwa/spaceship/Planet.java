package org.example.yunhwa.spaceship;

interface Planet { // 행성 : 수성, 금성, 화성, 목성, 토성, 천왕성, 해왕성

    void accept(SpaceShip shipVisiter);
}

class Mercury implements Planet {

    @Override
    public void accept(SpaceShip shipVisiter) {
        shipVisiter.visit(this);
    } //  수성

}

class Venus implements Planet {

    @Override
    public void accept(SpaceShip shipVisiter) {
        shipVisiter.visit(this);
    } //  금성


}

class Earth implements Planet {

    @Override
    public void accept(SpaceShip shipVisiter) {
        shipVisiter.visit(this);
    } //  지구

}

class Mars implements Planet {

    @Override
    public void accept(SpaceShip shipVisiter) {
        shipVisiter.visit(this);
    } //  화성

}

class Jupiter implements Planet {

    @Override
    public void accept(SpaceShip shipVisiter) {
        shipVisiter.visit(this);
    } //  목성


}

class Saturn implements Planet {

    @Override
    public void accept(SpaceShip shipVisiter) {
        shipVisiter.visit(this);
    } //  토성

}

class Uranus implements Planet {

    @Override
    public void accept(SpaceShip shipVisiter) {
        shipVisiter.visit(this);
    } //  천왕성

}

class Neptune implements Planet {

    @Override
    public void accept(SpaceShip shipVisiter) {
        shipVisiter.visit(this);
    } //  해왕성

}