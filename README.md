### 기능 요구사항
- 서로 다른 수로 이루어진 3자리 수를 맞추는 게임
- 예측값(사용자 Input) 과 문제의 숫자 중 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있다면 볼, 앞에 두가지에 포함되지 않으면 낫싱
- 컴퓨터가 임의의 서로 다른 한자리수 3개를 선택하고 사용자는 3개의 숫자를 입력하면 결과를 출력 정답일 경우 게임이 종료된다.
- 하나의 게임이 종료된 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

### 프로그래밍 요구사항
- Code Convention
    - Google Java Style Guide
    - tab : 4 spaces
- Indent 1 Depth 까지
- else 및 switch/case 사용 불가
- 모든 로직에 단위 테스트 구현 (UI 로직 제외) 
    - 핵심 로직과 UI 로직 분리해서 구현
    - UI 로직을 InputView, ResultView 와 같은 클래스를 추가해 분리
- 3항 연산자 사용 불가

### 구현 기능
1. InputView 구현
   - 사용자 3자리 수 입력 받는 함수 (length==3, OnlyNumber)
   - 종료 조건에 대한 응답 입력 받는 함수(Y or N)
2. Valid 구현
   - 숫자 입력에 대한 검증 함수
   - 종료 조건 입력에 대한 검증 함수
3. ResultView 구현
   - 볼, 스트라이크 개수에 따른 메시지 출력하는 함수
4. 숫자 생성기 
   - 중복되지 않는 랜덤한 3자리 수 생성
5. Game
   - Ball 개수 반환하는 함수
   - Strike 개수 반환하는 함수
   - 종료 조건 체크 함수
   - GameLoop 함수 