## Array Details
- ArrayIndexOutOfBoundsException: 배열의 범위를 넘어간 인덱스를 참조하려는 시도 발생
- NullPointerException: 배열 변수의 값이 null인 경우를 참조하려고 하는 시도 발생

7.1.1 for-each 루프
배열은 종종 for루프를 사용하여 처리된다. 각 요소를 시작부터 끝까지 처리하기 쉬움
간단하게 이렇게도 가능
```java
for (String name : namelist) { 
	System.out.println( name ); 
}
```
-그러나 for-each문이 항상 적합하지는 않다. 예를 들어 배열의 일부만 처리하거나 요소를 역순으로 처리하는 간단한 방법이 없다. 또한 배열 요소에 대한 값을 수정할 수 없다 !!
```java
int[] intList = new int[10];
for ( int item : intList ) {   // INCORRECT! DOES NOT MODIFY THE ARRAY!
   item = 17;
}
```

7.1.2 가변 인수 메서드 (Variable Arity Methods)
-자바5에서 도입됨
-메소드 호출마다 다른 수의 매개변수를 가질 수 있다.
```java
public static double average( double...  numbers ) {
```
- 여기서 타입 유형 뒤에 나오는 ...이 가변 인수 메소드임을 나타낸다.
- 가변 인수 메소드의 정의에서 가변 인수 목록은 하나 이상의 매개변수를 포함할 수 있지만 ...는 가장 마지막 형식 매개변수에만 적용할 수 있다.
```java
public static String concat( String... values ) {
   StringBuilder buffer;  // Use StringBuilder for more efficient concatenation.
   buffer = new StringBuilder();  // Start with an empty StringBuilder.
   for ( String str : values ) { // A "for each" loop for processing the values.
       buffer.append(str); // Add string to the buffer.
   }
   return buffer.toString(); // return the contents of the buffer
}
```

7.1.3 배열 리터럴
- 배열 변수를 선언할 때 초기 값을 주는 배열 변수를 선언할 때 초기 값을 주는 배열 리터럴
- 배열의 길이가 명시적으로 제공되지 않았지만 배열 리터럴에서 나열한 값의 수에 따라 자동으로 배열의 길이가 결정된다.
```java
String[] weekdays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
```

## Array Processing
7.2.1 몇 가지 처리 예제
![항목이 삭제될 때 부분적으로 가득 찬 배열이 어떻게 변경되는지](https://math.hws.edu/javanotes/c7/delete-from-array.png)
- 배열에서 요소를 삭제하는 경우 다음에 연결된 모든 항목들을 왼쪽으로 이동하고 배열의 마지막 공간은 빈공간으로 남아야 한다.
- B = A; 라 하더라도 복사를 하지는 않는다. 배열은 객체이며 배열 변수는 배열을 가리키는 포인터만 보유할 수 있다.

7.2.2 일부 표준 배열 방법
- 배열 복사는 자주 사용되는 방법으로 Java에는 이미 이 작업을 수행하는 내장 메소드가 정의되어 있다.
- java.util패키지에 속한 Arrays클래스의 정적 메소드로 정의된다.
```java
B = Arrays.copyOf(A, A.length); 
```
![[스크린샷 2023-09-21 오전 10.02.19.png]]
- 원하는 것이 원래 배열과 같은 크기의 간단한 배열 복사라면 더 간단한 방법도 있다. 모든 배열에는 배열을 복사하는 복제(clone)라는 인스턴스 메서드가 있다. 예를 들어 int 배열 A의 사본을 얻으려면 다음과 같이 할 수 있다.
```java
int[] B = A.clone();
```

```java
Arrays.fill(array, value) //지정된 값으로 전체 배열 채움
Arrays.fill(array, fromIndex, toIndex, value) //배열의 일부를 fromIndex부터 toIndex-1 번호까지 값으로 채운다. 
Arrays.toString(array)
Arrays.sort(array)
Arrays.sort(array, fromIndex, toIndex)
Arrays.binarySearch(array, value)//배열에서 value를 검색함, 이미 증가하는 순서로 정렬되어 있어야 함. 반환값은 해당 값을 포함하는 요소의 인덱스 값이 없으면 -1을 반환 
```

7.2.3 RandomStrings 재검토
parallel arrays: 메시지의 한 복사본에 대한 데이터가 여러 배열에 분산되어 있다
```java
g.setFill(Color.WHITE); // (Fill with white background.)
g.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
for (int i = 0; i < 25; i++) {
   g.setFill( color[i] );
   g.setFont( font[i] );
   g.fillText( MESSAGE, x[i], y[i] );
   g.setStroke(Color.BLACK);
   g.strokeText( MESSAGE, x[i], y[i] );
}
```
이 간단한 예에서 병렬 배열을 사용하는 것에는 문제가 없지만 관련된 데이터를 하나의 객체에 유지하는 객체지향 철학에 어긋납니다. 이 규칙을 따르면 데이터의 관계를 상상할 필요가 없으므로 메시지의 한 복사본에 대한 모든 데이터가 물리적으로 하나의 장소에 있으므로 더 나은 설계입니다. 따라서 프로그램을 작성할 때 한 메시지 복사본에 필요한 모든 데이터를 나타내는 간단한 클래스를 만들었습니다

## *보충*
- 프레임워크: 사용방법을 미리 정해 놓은 라이브러리
- 컬렉션의 특징 정리
1. Collection
1) List: 순서를 유지하고 저장, 중복 저장 가능 (ArrayList, Vector, LinkedList)
2) Set: 순서를 유지하지 않고 저장, 중복 저장 안 됨 (HashSet, TreeSet)
2. Map: 키와 값의 쌍으로 저장, 키는 중복 저장 안 됨 (HashMap, Hashtable, TreeMap, Properties)

- List 컬렉션
  -객체 자체를 저장하는 것이 아니라 객체의 번지를 참조한다.
  -메소드
1) boolean add(E e)
2) void add(int index, E element)
3) E set(int index, E element)
4) boolean contains(Object o)
5) E get(int index)
6) boolean isEmpty
7) int size()
8) void clear()
9) E remove(int index)
10) boolean remove(Object o)

- (1) ArrayList
  -List인터페이스의 구현 클래스로, 객체를 추가하면 인덱스로 관리된다. 일반 배열은 생성할 때 크기가 고정되고 사용 중에 크기를 변경할 수 없지만, ArrayList는 저장 용량을 초과한 객체들이 들어오면 자동적으로 저장 용량이 늘어난다.
```java
List<String> list = new ArrayList<String>();
```
-ArrayList에 객체를 추가하면 인덱스 0부터 차례대로 저장된다 특정 인덱스의 객체를 제거하면 바로 뒤 인덱스부터 마지막 인덱스까지 모두 앞으로 1씩 당겨진다 마찬가지로 특정 인덱스에 객체를 삽입하면 해당 인덱스부터 마지막 인덱스까지 모두 1씩 밀려난다.
-따라서 빈번한 객체 삽입과 삭제가 일어나는 곳에서는 ArrayList를 사용하는 것이 바람직하지 않다. 이런 경우라면 LinkedList를 사용하는 것이 좋다.
-그러나 인덱스 검색이나, 맨 마지막에 객체를 추가하는 경우에는 ArrayList가 더 좋은 성능을 발휘한다.
-Arrays.asList(T... a);를 사용해서 배열을 List로 변환해준다.
`Arrays.asList()`를 사용하여 생성된 리스트는 원래 배열과 동기화되므로 한 쪽에서 데이터를 수정하면 다른 쪽에도 반영됩니다. 이를 고려하여 사용해야 한다.

## Records
7.4.1  Basic Java Records
: 자바 레코드(Java Record)는 특수한 종류의 클래스인 레코드 클래스(record class)에 속하는 객체, 가장 간단한 경우에 레코드 클래스는 레코드의 필드를 나타내는 인스턴스 변수 집합만 지정