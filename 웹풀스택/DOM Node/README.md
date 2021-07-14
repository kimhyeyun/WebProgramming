# DOM Node 조작하기

``` 
DOM, 즉 HTML은 동적으로 다양하게 변경될 수 있음.   
DOM APIs 에서는 다양한 메서드와 속성을 지원하고 있으니 이를 활용하는 방법을 배울 필요가 있음   
```

## DOM 엘리먼트 오브젝트
### 몇 가지 유용한 DOM 엘리먼트 속성
> tageName : 엘리먼트 태그명 반환   
> textContent : 노드의 텍스트 내용으 설정하거나 반환   
> nodeType : 노드의 노드 유형을 숫자로 반환   

### DOM 탐색 속성
- childNodes
  - 엘리먼트의 자식 노드의 노드 리스트 반환
- firstChild
  - 엘리먼트의 첫 번째 자식 노드를 반환
- firstElementChild
  - 첫 번째 자식 엘리먼트를 반환
- parentElement
  - 엘리먼트의 부모 엘리먼트 반환
- nextSibling
  - 동일한 노드 트리 레벨에서 다음 노드를 반환
- nextElementSibling
  - 동일한 노드 트리 레벨에서 다음 엘리먼트 반환

### DOM 조작 메소드
- removeChild()
  - 엘리먼트의 자식 노드 제거
- appendChild()
  - 마지막 자식 노드로 자식 노드를 엘리먼트에 추가
- insertBefore()
  - 기존 자식 노드 앞에 새 자식 노드 추가
- cloneNode()
  - 노드를 복제
- replaceNode()
  - 엘리먼트의 자식 노드 바꿈
- closet()
  - 상위로 올라가면서 가장 가까운 엘리먼트를 반환

   
### HTML을 문자열로 처리해주는 DOM 속성 / 메서드
- innerText
  - 지정된 노드와 모든 자손의 텍스트 내용을 설정하거나 반환
- innerHTML
  - 지정된 엘리먼트의 내부 html을 설정하거나 반환
- insertAdjacentHTML()
  - HTML로 텍스트를 지정된 위치에 삽입
