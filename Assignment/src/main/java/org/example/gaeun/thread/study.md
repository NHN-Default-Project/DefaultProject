1. Runnable vs Thread
* Runnable: interface 재사용성이 높고, 코드의 일관성을 유지할 수 있다. 
* Thread: 상속을 받아 사용해야 하기 때문에 다른 클래스를 상속받아 사용할 수 없다는 단점이 있다. 
* 일반적으로는 Runnable인터페이스를 구현해서 스레드를 사용한다. 