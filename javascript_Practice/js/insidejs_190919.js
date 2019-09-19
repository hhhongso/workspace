/* chapter3: 자바스크립트 데이터 타입과 연산자  */

/* ***** 3.1 자바스크립트 기본형 데이터 타입 *****
1) 기본타입: 숫자, 문자열, boolean, undefined, null
		- 숫자: int/double/float 구분 없음. 모든 숫자는 실수로 처리한다. 
		- 문자: char/string/""/'' 구분 없음. 한 번 정의된 문자열은 수정불가. 
2) 참조타입: 객체 (배열, 함수, 정규표현식)
		- 상기 기본타입 5개를 제외한 모든 값은 객체이다. 

cf) undefined와 null의 차이
				타입			값
undefined	undefined	undefined
null		object		null

*/

//ex3-4
var nullVar = null; 
console.log(nullVar);

console.log('-------------------------------------------------------------------'); /* **** 3.2 자바스크립트 참조형 타입 *****/
//ex3-5: 객체생성방법1) Object() 객체의 생성자 함수로 
var foo = new Object();

foo.name = 'foo';
foo.age = 30; 
foo.gender = 'male';

console.log(typeof foo);
console.log(foo);

console.log('-------------------------------------------------------------------');
//ex3-6: 객체생성방법2) 객체 리터럴 {} 으로
var foo = {
	name: 'foo',
	age: 30,
	gender: 'male'
}

console.log(typeof foo);
console.log(foo);

console.log('-------------------------------------------------------------------');
//ex3-7: 객체 프로퍼티
var foo = {
		name: 'foo',
		major: 'computer science'
};
console.log(foo.name); //객체의 프로퍼티에 접근: . 를 통해 
console.log(foo['name']); //객체의 프로퍼티에 접근: [] 를 통해 
console.log(foo.nickname);

foo.major = 'history education';
console.log(foo.major);
console.log(foo['major']);

foo.age = 30;
console.log(foo.age);

/*
접근하려는 프로퍼티가 표현식이거나 예약어일 경우, 반드시 [] 표현법만을 사용한다. 
아래 full-name 이라는 프로퍼티는 - 연산자가 들어있는 표현식이기 때문에, [] 으로만 접근하여야 한다.  */

foo['full-name'] = 'foo bar';
console.log(foo['full-name']);
//console.log(foo.full-name); foo.full-name이라고 할 경우, full -(minus) name 이라고 인식하여 NaN(Not a Number) 혹은 에러를 띄운다.
//console.log(foo.full);
console.log(foo.name);

console.log('-------------------------------------------------------------------');
/*for in 문으로 객체 프로퍼티 출력*/
//ex3-8
var prop; 
for(prop in foo){
	console.log(prop,':'+ foo[prop]);
}


console.log('-------------------------------------------------------------------');
/*객체 프로퍼티 삭제: delte 연잔자는 객체 프로퍼티를 삭제할 뿐, 객체 자체를 삭제하지 못한다. */
delete foo.age;
console.log(foo.age); //프로퍼티가 삭제되어 undefined가 된다. 
for(prop in foo){
	console.log(prop, ":"+ foo[prop]);
}


console.log('-------------------------------------------------------------------'); /* **** 3.3 참조 타입의 특성 *****/

/*객체의 모든 연산은 실제 값이 아닌 참조 값으로 처리된다. ***/

//ex3-9
var objA = {
		val: 40
};
var objB = objA; // objA 객체를 objB에 할당함으로써, A가 가리키는 참조값이 B에 동일하게 저장된다(objA 와 objB가 같은 값을 참조한다.)

console.log("valA: " + objA.val + " valB: " +objB.val);

objB.val = 50; 
console.log("valA: " + objA.val + " valB: " +objB.val);

objA.val = 60; 
console.log("valA: " + objA.val + " valB: " +objB.val);

console.log('-------------------------------------------------------------------');
/*객체 비교 : 동등연산자(==) 사용하여 비교 시, 객체의 프로퍼티 값이 아닌 참조값을 비교한다.*/
//ex3-10
var a = 100, b = 100; 
var objA={ val: 100 };
var objB={ val: 100 };
var objC= objB; 

console.log(a == b);
console.log(objA == objB); //false. 값이 아닌 참조주소이기 때문. objA.val == objB.val (true) 
console.log(objB == objC);


console.log('-------------------------------------------------------------------'); /* **** 3.4 프로토타입 *****/
/*모든 객체는 자신의 부모 역할을 하는 객체와 연결되어 있으며, 자식은 부모 객체의 것을 상속받는다. 이러한 부모 객체를 프로토타입 객체 (프로토타입) 이라고 한다. */
//ex3-12
var foo = {
	name: 'foo',
	age: 30
};

console.log(foo.toString());
console.dir(foo); 
//크롬창에서 실행 시, 자기자신 외에 다른 프로퍼티들을 확인할 수 있다. (__proto__: object. 최상위 객체 object 의 모든 것을 상속받음.)
//즉, 부모객체 = 프로토타입 = object 

console.log('-------------------------------------------------------------------'); /* **** 3.5 배열 *****/

//ex3-13: 배열 리터럴: [] 으로 생성
var colorArr= ['orange', 'red', 'blue', 'green', 'yellow'];
console.log(colorArr[0]);

//ex3-14: 배열요소의 동적 생성
//순차적으로 값을 넣을 필요 없이, 아무 인덱스 위치에나 값을 동적으로 추가할 수 있다.

var arr= []; // 빈 배열 생성
console.log(arr[0]); //undefined
arr[0] = 100; 
arr[3] = 'eight';
arr[7] = true;
console.log(arr);
console.log(arr.length);

console.log('-------------------------------------------------------------------');
//ex3-15: 배열의 length 프로퍼티 변경 - 모든 배열은 length 프로퍼티가 있다. 
var arr = [];
arr[0] = 0; 
arr[1] = 1; 
arr[2] = 2;
console.log(arr.length)
arr[100] = 100;
console.log(arr.length)

console.log('-------------------------------------------------------------------');
//ex3-16: 배열 length 프로퍼티의 명시적 변경
var arr= [0, 1, 2];
console.log(arr.length);

arr.length = 5; 
console.log(arr.length);
console.log(arr);

console.log('-------------------------------------------------------------------');
arr.length = 2; 
console.log(arr);
console.log(arr[2]);

console.log('-------------------------------------------------------------------');
/*배열 표준 메서드와 length 프로퍼티 
: 배열 메서드는 length 프로퍼티를 기반으로 동작한다. 
: push() 메서드는 표준 배열 메서드로, 현재 배열의 끝에(length값의 위치에) 새로운 원소값을 추가한다. 
*/
var arr= [0, 1, 2];
arr.push(3);
console.log(arr);

arr.length = 5; 
arr.push(4);
console.log(arr);

console.log('-------------------------------------------------------------------');
/*배열과 객체의 차이 */

//ex3-18
var colorsArr = ['orange', 'yellow', 'green'];
var colorsObj = {'0': 'orange', '1': 'yellow', '2': 'green'}; // 1. 객체의 프로퍼티 접근 시 [] 안의 프로퍼티 속성은 문자열 형태로 적어야 한다.

console.log(colorsArr[0]);
console.log(colorsObj[0]); //1. 단, 출력 시에는 [] 연산자 내에 숫자가 사용될 경우, 자동으로 문자열 형태로 변환한다. 

console.log(typeof colorsArr);
console.log(typeof colorsObj); //2. 함수, 배열, 정규표현식은 모두 객체이다. (객체 ⊃ 배열) 즉, type of colorsArr = object. 

console.log(colorsArr.length);
console.log(colorsObj.length);

colorsArr.push('red');
//colorsObj.push('red'); - 불가

console.log('-------------------------------------------------------------------');
//ex3-19
var arr = [];
var obj = {};

console.dir(arr.__proto__); // ⊂ Array ⊂ Object 
console.dir(obj.__proto__); // Object

console.log('-------------------------------------------------------------------');
//ex3-20
var arr = ['zero', 'one', 'two'];
console.log(arr.length);

arr.color= 'blue'; //프로퍼티 추가: length 에 영향을 주지 않음. 
arr.name = 'number_array';
console.log(arr.length);

arr[3] = 'red'; //배열 원소 추가: length 에 영향. 
console.log(arr.length);

console.dir(arr);

console.log('-------------------------------------------------------------------');
//배열의 프로퍼티 열거: for in 문과 for문의 차이 
//ex3-21
for(var prop in arr){ //for in 문은: arr 변수(배열) 에 들어있는 모든 것을 하나하나 가져오기 때문에, 프로퍼티까지 가져온다. 
	console.log(prop, ": "+ arr[prop]);
}

for (var i = 0; i < arr.length; i++) { //for문은 : arr.length 만큼 반복하기 때문에, 배열 요소만 가져온다. 
	console.log(i, ": "+ arr[i]);
	
}

console.log('-------------------------------------------------------------------');
//배열 요소 삭제 : 1) delete 2)splice
/*delete 사용 시,  요소를 삭제한 뒤에도 <1 empty item>(undefined) 으로 배열에 남아있는다. => length 는 그대로
splice 사용 시, 요소를 완전히 삭제한다. => length 변화 */ 
var arr = ['zero', 'one', 'two', 'three'];
delete arr[2];
console.log(arr);
console.log(arr.length);

var arr = ['zero', 'one', 'two', 'three'];
arr.splice(2, 1); //2번째 요소를 시작점으로 1개 원소를 삭제한다. 
console.log(arr);
console.log(arr.length);


console.log('-------------------------------------------------------------------');
//Array() 생성자 함수 사용
var foo = new Array(3);
console.log(foo);
console.log(foo.length);

var bar = new Array(1, 2, 3);
console.log(bar);
console.log(bar.length);

console.log('-------------------------------------------------------------------');
//유사 배열 객체 
/*일반적으로 length 프로퍼티는 배열 객체에만 존재하나, 일부 다른 객체에서도 length 프로퍼티를 가지고 있다. 이러한 객체를 유사 배열 객체라고 한다. 
유사 배열 객체는 일반 객체와 달리, 표준 배열 메서드를 사용할 수 있다. 단, apply() 메서드를 사용하여 가능하다. 
*/

var arr = ['bar'];
var obj = {	name: 'foo', lengh: 1};

arr.push('bar2');
console.log(arr);
//obj.push('foo2'); - 에러: 그냥 곧바로 push()를 사용할 수는 없으나, apply()를 통해 가능하다. 
Array.prototype.push.apply(obj, ['foo2']);
console.log(obj);
