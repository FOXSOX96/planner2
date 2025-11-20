# 1. API 명세 
---
title: planner2 API Docs
language_tabs:
- shell: Shell
- http: HTTP
- javascript: JavaScript
- ruby: Ruby
- python: Python
- php: PHP
- java: Java
- go: Go
  toc_footers: []
  includes: []
  search: true
  code_clipboard: true
  highlight_theme: darkula
  headingLevel: 2
  generator: "@tarslib/widdershins v4.0.30"

---

# planner2 API Docs

## POST create planner

POST /users/{userId}/planners

> Body Parameters

```json
{
  "name": "홍길동",
  "title": "오늘할일",
  "content": "플래너필수1"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|userId|path|string| yes |none|
|body|body|object| no |none|
|» name|body|string| yes |none|
|» title|body|string| yes |none|
|» content|body|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## GET get planner user's list

GET /users/{userId}/planners

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|userId|path|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## GET get planner

GET /planners/{plannerId}

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|plannerId|path|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## PATCH update planner

PATCH /planners/{plannerId}

> Body Parameters

```json
"{\n    \"name\" : \"홍길동2\"\n    \"title\" : \"오늘할일2\"\n    \"content\" : \"오늘일정2\"\n}"
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|plannerId|path|string| yes |none|
|body|body|object| no |none|
|» name|body|string| yes |none|
|» title|body|string| yes |none|
|» content|body|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## DELETE delete planner

DELETE /planners/{plannerId}

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|plannerId|path|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## GET get planner page

GET /planners

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|page|query|string| yes |none|
|size|query|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## POST create user

POST /users

> Body Parameters

```json
{
  "name": "임꺽정",
  "email": "임꺽정@gmail.com",
  "password": "abcd1234!"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» name|body|string| yes |none|
|» email|body|string| yes |none|
|» password|body|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## GET get user list

GET /users

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## GET get user

GET /users/{userId}

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|userId|path|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## PATCH update user

PATCH /users/{userId}

> Body Parameters

```json
{
  "name": "임꺽정2",
  "password": "abcd1234!",
  "newPassword": "abcd1234!!"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|userId|path|string| yes |none|
|body|body|object| no |none|
|» name|body|string| yes |none|
|» password|body|string| yes |none|
|» newPassword|body|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## DELETE delete user

DELETE /users/{userId}

> Body Parameters

```json
{
  "email": "임꺽정@gmail.com",
  "password": "abcd1234!"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|userId|path|string| yes |none|
|body|body|object| no |none|
|» email|body|string| yes |none|
|» password|body|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## POST create comment

POST /planners/{plannerId}/users/{userId}/comments

> Body Parameters

```json
{
  "content": "댓글4"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|plannerId|path|string| yes |none|
|userId|path|string| yes |none|
|body|body|object| no |none|
|» content|body|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## GET get comment

GET /planners/{plannerId}/comment/{commentId}

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|plannerId|path|string| yes |none|
|commentId|path|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## PATCH update comment

PATCH /planners/{plannerId}/comment/{commentId}

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|plannerId|path|string| yes |none|
|commentId|path|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## DELETE delete comment

DELETE /planners/{plannerId}/comment/{commentId}

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|plannerId|path|string| yes |none|
|commentId|path|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## GET get comment list

GET /planners/{plannerId}/comments

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|plannerId|path|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## POST logoutSession

POST /logins

> Body Parameters

```json
{
  "email": "임꺽정@gmail.com",
  "password": "1234"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» email|body|string| yes |none|
|» password|body|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

## GET testSession

GET /sessions/tests

> Body Parameters

```json
{
  "email": "임꺽정@gmail.com",
  "password": "abcd1234!"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» email|body|string| yes |none|
|» password|body|string| yes |none|

> Response Examples

> 200 Response

```json
{}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|


# 2. Planner2

간단한 일정 플래너 애플리케이션입니다.  
유저(User) – 플래너(Planner) – 댓글(Comment) 구조를 가지고 있으며,  
세션 기반 로그인으로 인증을 처리합니다.

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Web / Spring Data JPA
- MySQL
- Lombok
- (Postman 또는 REST 클라이언트로 테스트)

---

##  ERD

엔티티 간 관계는 다음과 같습니다.

- `users`
    - `id` (PK)
    - `name`
    - `email`
    - `password`
    - `created_at`
    - `modified_at`

- `planners`
    - `id` (PK)
    - `user_id` (FK → users.id)
    - `title`
    - `content`
    - `created_at`
    - `modified_at`

- `comments`
    - `id` (PK)
    - `planner_id` (FK → planners.id)
    - `user_id` (FK → users.id)
    - `content`
    - `created_at`
    - `modified_at`

관계 정리:

- 한 `User` 는 여러 `Planner` 를 가질 수 있습니다. (1:N)
- 한 `Planner` 는 여러 `Comment` 를 가질 수 있습니다. (1:N)
- 각 `Comment` 는 작성자 `User` 와 대상 `Planner` 를 참조합니다.

# ERD 다이어그램
![ERD 다이어그램](./images/erd.png)