# Fooding — 남는 식재료를 이웃과 나누는 식품 공유 플랫폼

> **2025 제로톤 경진대회 우수상** · 단국대학교 SW중심대학사업단

혼자 사는 사람이 식재료 한 묶음을 사면 늘 남습니다. 식당은 재고가 남고,
개인은 조금씩 모자랍니다. **남는 재료와 필요한 재료를 위치 기반으로 연결해**
버려지는 음식을 줄이자는 아이디어에서 출발한 서비스입니다.

---

## 핵심 개념

| 개념 | 설명 |
|---|---|
| **나눔 / 교환** | 재료를 그냥 주거나(SHARE), 서로 바꾸거나(EXCHANGE) |
| **줄 재료 / 받을 재료** | 등록할 때 주고 싶은 재료(GIVE)와 받고 싶은 재료(TAKE)를 구분 |
| **개인 / 사업자** | 개인 사용자와 요식업 사업자를 구분해 공급·수요를 맞춤 |
| **위치 기반 매칭** | 사용자 좌표를 기준으로 가까운 거래 상대를 찾음 |
| **유통기한 관리** | 재료마다 유통기한을 입력해 임박한 것부터 우선 노출 |

---

## 저장소 구성

```
.
├── backend/     Spring Boot REST API (Java · JPA · MySQL)
├── frontend/    React 웹 클라이언트
└── prototype/   초기 화면 설계 시안 (HTML · CSS)
```

### backend

Spring Boot 기반 REST API입니다. `controller` · `service` · `repository` · `model`
4계층으로 분리했고, JPA로 영속성을 처리합니다.

**도메인 모델**

| 엔티티 | 주요 필드 |
|---|---|
| `User` | 이름, 연락처, 지역, 사용자 유형(개인/사업자) |
| `Ingredient` | 재료명, 중량, 유통기한, 등록 모드(GIVE/TAKE), 공유 여부 |
| `Match` | 제공자, 수령자, 대상 재료, 거래 유형(나눔/교환) |
| `Like` | 사용자 간 평가 (보낸 사람 / 받은 사람) |
| `Location` | 사용자 좌표 (위도 · 경도) |

**API**

| 경로 | 역할 |
|---|---|
| `/api/users` | 사용자 등록 · 조회 · 삭제 |
| `/api/ingredients` | 재료 등록, 사용자별 조회, 모드별(GIVE/TAKE) 조회 |
| `/api/matches` | 나눔 · 교환 매칭 생성과 조회 |
| `/api/likes` | 사용자 간 평가 등록 · 조회 |
| `/api/locations` | 사용자 위치 등록 · 조회 |

**실행**

```bash
cd backend
# src/main/resources/application.yml 의 DB 접속 정보를 환경에 맞게 수정
./gradlew bootRun
```

MySQL에 `fooding` 데이터베이스를 미리 만들어 두어야 합니다. 테이블은 JPA가
`ddl-auto: update` 설정으로 자동 생성합니다. 기본 포트는 8080입니다.

### frontend

Create React App 기반 클라이언트입니다. `src/api/userApi.js`에서 백엔드 REST API를
호출합니다.

```bash
cd frontend
npm install
npm start
```

### prototype

기획 단계에서 만든 화면 시안입니다. 로그인, 회원가입, 재료 등록, 교환,
프로필 등 주요 화면의 구조를 먼저 잡고 구현에 들어갔습니다.

| 화면 | 파일 |
|---|---|
| 메인 | `fooding.html` |
| 로그인 · 회원가입 | `fooding_login.html` · `fooding_signup.html` |
| 재료 등록 | `register_ingredient.html` |
| 교환 | `exchange.html` |
| 기능 선택 | `feature_select.html` |
| 프로필 | `profile.html` |

---

## 기술 스택

| 영역 | 사용 기술 |
|---|---|
| 백엔드 | Java, Spring Boot, Spring Data JPA, Gradle |
| 데이터 | MySQL |
| 프론트엔드 | React, axios |
| 프로토타입 | HTML, CSS, JavaScript |

---

## 비고

- 이 저장소는 흩어져 있던 세 저장소(`Fooding1` 백엔드 · `Fooding2` 프론트엔드 ·
  `fooding-frontend` 시안)를 하나로 합친 것입니다.
- 경진대회 기간에 맞춰 개발한 프로토타입으로, 실제 서비스로 배포하지는 않았습니다.
- 설정 파일의 DB 접속 정보는 로컬 개발용 예시값입니다.

### 복원 작업

대회 당시 동작하던 버전은 유실되었고, 저장소에 남아 있던 코드만으로는 빌드가
되지 않는 상태였습니다. 남은 코드를 기준으로 빌드 가능한 상태를 복원했습니다.
도메인 로직과 API 설계는 원본 그대로 두고, 구조와 설정만 바로잡았습니다.

| 항목 | 복원 내용 |
|---|---|
| 메인 클래스 위치 | `src/` → `src/main/java/com/fooding/` (Gradle 소스 경로 복구) |
| 설정 파일명 | `aplication.yml` → `application.yml` |
| `IngredientRepository` | `IngredientMode` import 복원 |
| `package.json` | 사용 중이던 `axios` 의존성 복원 |

빌드 캐시(`.gradle/`)와 맥 압축 부산물(`__MACOSX/`)도 함께 정리했습니다.
현재 상태에서 `./gradlew compileJava`와 `npm run build` 모두 통과합니다.
