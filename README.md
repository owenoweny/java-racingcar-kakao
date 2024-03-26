# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 레이싱 게임

## 기능 목록

- 게임 결과를 출력한다.
    - 턴이 진행될 때마다 결과를 출력한다.
    - 최종 승리자를 출력한다.
- 게임 내용을 입력받는다.
    - 자동차 이름은 ','로 구분되어야한다.
    - 자동차 이름은 5자 이하여야한다.
- 자동차를 이동시킨다.
    - 랜덤 생성한 값이 4 이상일 경우 전진한다.

# 문자열 덧셈 계산기

## 기능 목록

- 수식을 입력받는다.
    - 음수 또는 숫자가 아닌 값인 경우, RumtimeException을 발생시킨다.
- 계산 결과를 출력한다.
    - null 또는 빈 문자열인 경우 0을 출력한다.
- 수식을 파싱한다.
    - ',', ':'를 구분자로 정수 문자열의 합을 계산한다.
    - 커스텀 구분자가 있는 경우, 이를 구분자로 갖는 정수 문자열의 합을 계산한다.
    - 정규표현식의 예악어는 커스텀 구분자가 될 수 없다.
