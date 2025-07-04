# [Silver II] 아이템 배치하기 - 21599 

[문제 링크](https://www.acmicpc.net/problem/21599) 

### 성능 요약

메모리: 68228 KB, 시간: 880 ms

### 분류

그리디 알고리즘, 정렬

### 제출 일자

2025년 6월 28일 15:59:06

### 문제 설명

<p>최근 싸이컴에서 제작한 게임 ‘입부 전쟁’에서는 다양한 아이템을 활용해 전쟁의 승리 확률을 높일 수 있습니다. 아이템은 한 번에 $N$개씩 강화할 수 있습니다.</p>

<p>강화력이 각각 $A_1, A_2, \cdots, A_N$인 $N$개의 아이템을 강화하려고 할 때, 아이템을 강화하는 방법은 다음과 같습니다.</p>

<ul>
	<li>$N$개의 아이템을 적절한 순서로 원형으로 배열합니다.</li>
	<li>$i$번 아이템은 자신부터 시작해, 시계 방향으로 $A_i$개의 아이템을 강화시킵니다. $A_i=0$인 아이템의 경우 다른 아이템에게 아무 영향도 주지 않습니다.</li>
	<li>만약 위 규칙에 의해 여러 번 강화되는 아이템이 있다면, 실제로는 한 번만 강화됩니다.</li>
</ul>

<p>브루는 ‘입부 전쟁’ 세계 1위를 기록한 흑왕을 이기기 위해 아이템을 강화하려고 합니다. 하지만 브루는 어떤 식으로 배치해야 최대한 많은 아이템을 강화할 수 있을지 찾지 못했고, 당신에게 도움을 요청했습니다. 그러나 당신도 ‘입부 전쟁’ 게임을 열정적으로 하는 플레이어이기 때문에, 브루의 아이템 강화를 방해하려고 합니다. 따라서 당신은 브루의 부탁대로 가장 많은 아이템을 강화하게 하는 대신, 가장 적은 아이템을 강화시키는 방법을 찾으려고 합니다.</p>

<p>$N$개의 아이템과 각각의 강화력 $A_1, A_2, \cdots, A_N$이 주어졌을 때, 최대한 적은 아이템만 강화되게 하고, 그때 강화되는 아이템의 수를 구해 출력하세요.</p>

### 입력 

 <p>첫 줄에는 아이템의 수를 나타내는 정수 $N$이 주어집니다.</p>

<p>둘째 줄에는 각 아이템의 강화력을 나타내는 정수 $A_1, A_2, \cdots, A_N$이 주어집니다.</p>

### 출력 

 <p>가능한 모든 아이템 배치들 중에서, 강화되는 아이템 수의 최솟값을 출력합니다.</p>

