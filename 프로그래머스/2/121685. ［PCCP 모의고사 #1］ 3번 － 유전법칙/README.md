# [level 2] [PCCP 모의고사 #1] 3번 - 유전법칙 - 121685 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/121685) 

### 성능 요약

메모리: 87 MB, 시간: 0.03 ms

### 구분

프로그래밍 강의 > PCCP 모의고사 1회

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 02월 18일 23:59:00

### 문제 설명

<p>멘델은 완두콩을 이용하여 7년간 실험한 결과, 다음과 같은 특별한 법칙을 발견하였습니다.</p>

<ol>
<li>둥근 완두 순종(RR)을 자가 수분, 즉 같은 유전자끼리 교배할 경우, 다음 세대에 둥근 완두 순종 형질만 나타난다.</li>
<li>주름진 완두 순종(rr)을 자가 수분할 경우, 다음 세대에 주름진 완두 순종 형질만 나타난다.</li>
<li>두 순종을 교배한 잡종(Rr)을 자가 수분할 경우, 다음 세대의 형질은 RR:Rr:rr=1:2:1의 비율로 나타난다. (아래 그림 참조)</li>
</ol>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/22c1e8fc-093c-491b-8604-dad8f553b631/image1.PNG" title="" alt="image1.PNG"></p>

<p>멘델의 법칙을 공부한 진송이는, 직접 완두콩의 자가 수분 실험을 진행했습니다. 진송이의 실험에서 완두콩 한 개를 자가 수분한 결과는 다음과 같습니다.</p>

<ol>
<li>각 완두콩은 자가 수분해서 정확히 4개의 완두콩 후손을 남긴다.</li>
<li>잡종 완두콩(Rr)은 자가 수분해서 첫째는 RR, 둘째와 셋째는 Rr, 넷째는 rr 형질의 후손을 남긴다.</li>
<li>순종 완두콩(RR, rr)은 자가 수분해서 자신과 같은 형질의 후손을 남긴다.</li>
</ol>

<p>잡종 완두콩(Rr) 1대부터 시작한 가계도로 그려보면 그림 2와 같습니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/95a0f907-0e3c-4c4e-acfe-bb489685802b/image2.PNG" title="" alt="image2.PNG"></p>

<p>진송이는 이러한 완두콩의 자가 수분 실험 결과를 정리하고 싶어합니다. 하지만, 세대를 거듭할수록, 완두콩의 수가 너무 많아져 모든 가계도를 기록하기 어려워졌습니다. 진송이는 가계도를 전부 기록하는 것 대신, 완두콩의 세대와 해당 세대에서 몇 번째 개체인지를 알면 형질을 바로 계산하는 프로그램을 만들려 합니다.</p>

<p>각 세대에서 맨 왼쪽 개체부터 첫 번째, 두 번째, 세 번째, ...개체로 나타냅니다. 예를 들어 그림 2에서 2세대의 네 번째 개체의 형질은 "rr"이며, 3세대의 9번째 개체의 형질은 "RR"입니다.</p>

<p>형질을 알고 싶은 완두콩의 세대를 나타내는 정수 <code>n</code>과, 해당 완두콩이 세대 내에서 몇 번째 개체인지를 나타내는 정수 <code>p</code>가 2차원 정수 배열 <code>queries</code>의 원소로 주어집니다. <code>queries</code>에 담긴 순서대로 <code>n</code>세대의 <code>p</code> 번째 개체의 형질을 문자열 배열에 담아서 return 하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>queries</code>의 길이(쿼리의 개수) ≤ 5</li>
<li><code>queries</code>의 원소는 [<code>n</code>, <code>p</code>] 형태입니다.

<ul>
<li>1 ≤ <code>n</code> ≤ 16</li>
<li>1 ≤ <code>p</code> ≤ 4<sup>n-1</sup></li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>queries</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[[3, 5]]</td>
<td><code>["RR"]</code></td>
</tr>
<tr>
<td>[[3, 8], [2, 2]]</td>
<td><code>["rr", "Rr"]</code></td>
</tr>
<tr>
<td>[[3, 1], [2, 3], [3, 9]]</td>
<td><code>["RR", "Rr", "RR"]</code></td>
</tr>
<tr>
<td>[[4, 26]]</td>
<td><code>["Rr"]</code></td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<ul>
<li>본문의 가계도를 참고하면 3세대의 5번째 개체의 형질이 RR임을 알 수 있습니다.</li>
</ul>

<p><strong>입출력 예 #2</strong></p>

<ul>
<li>본문의 가계도를 참고하면 3세대의 8번째 개체의 형질이 rr임을 알 수 있습니다.</li>
<li>본문의 가계도를 참고하면 2세대의 2번째 개체의 형질이 Rr임을 알 수 있습니다.</li>
</ul>

<p><strong>입출력 예 #3</strong></p>

<ul>
<li>본문의 가계도를 참고하면 3세대의 1번째 개체의 형질이 RR임을 알 수 있습니다.</li>
<li>본문의 가계도를 참고하면 2세대의 3번째 개체의 형질이 Rr임을 알 수 있습니다.</li>
<li>본문의 가계도를 참고하면 3세대의 9번째 개체의 형질이 RR임을 알 수 있습니다.</li>
</ul>

<p><strong>입출력 예 #4</strong></p>

<ul>
<li>4세대의 26번째 개체는 3세대의 7번째 개체(Rr)의 둘째 후손으로, 형질은 Rr이 됩니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges