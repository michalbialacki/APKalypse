# :core-ui

Design system modułu `app` i przyszłych feature-modułów. Android library, pakiet
`com.mibia.apkalypse.core.ui`. Bez zależności od warstwy domain/data — czysty
Compose + Material3.

## Struktura

```
src/main/kotlin/com/mibia/apkalypse/core/ui/
├── theme/
│   ├── Color.kt      # paleta light/dark (wygenerowana z Material Theme Buildera)
│   ├── Type.kt       # AppTypography — Google Fonts (AR One Sans / Abril Fatface)
│   ├── Shape.kt       # AppShapes — Material3 Shapes (RoundedCornerShape, extraSmall..extraLarge)
│   └── Theme.kt       # AppTheme — MaterialTheme wrapper spinający powyższe trzy
└── components/
    ├── AppButton.kt
    ├── AppTextField.kt
    ├── AppTopBar.kt
    ├── LoadingIndicator.kt
    └── ErrorState.kt
```

Każdy komponent ma odpowiadający test w `src/androidTest/.../components/`.

## Komponenty

- **`AppButton(onClick, modifier, text, enabled)`** — wrapper na Material3 `Button`.
- **`AppTextField(state, modifier, validate)`** — wrapper na Material3 `TextField`.
  `state: TextFieldState` jest hoistowany (tworzony przez wołającego, nie wewnątrz
  komponentu), a `validate: (String) -> Boolean` steruje pokazywaniem błędu
  (`isError` + `supportingText`). Ta hoistowana forma jest świadomym wyborem — patrz
  `markdowns/PostPhase01Writeup.md`.
- **`AppTopBar(title, modifier, navigationIconButtonClickMethod, actionIconButton)`** —
  `CenterAlignedTopAppBar` z ikoną wstecz (`contentDescription = "Primary navigation
  action"`) i slotem na dowolną akcję.
- **`LoadingIndicator(modifier, message)`** — `CircularProgressIndicator` + opcjonalny
  tekst (ukrywany, gdy `message` jest `null` lub puste/białe znaki).
- **`ErrorState(message, errorIcon, retryMethod)`** — komunikat błędu + przycisk
  retry (`contentDescription = "Retry"`).

## Theme

```kotlin
AppTheme(darkTheme = isSystemInDarkTheme()) {
    // content
}
```

`AppTheme` przełącza `lightScheme`/`darkScheme` i przekazuje `AppTypography`
i `AppShapes` do `MaterialTheme`.

## Zasady rozszerzania modułu

1. Nowy komponent = jeden plik w `components/`, `@Composable`, bez zależności od
   Android SDK poza samym Compose (moduł nie zna warstwy domain/data).
2. Do każdego komponentu dopisz test w `androidTest/.../components/` — selektoruj
   po `contentDescription`/`testTag`, nie po tekście widocznym dla użytkownika
   (klikalny element rzadko pokrywa się z tekstem etykiety obok niego).
3. Kolory/typografia/kształty idą wyłącznie przez `theme/`, nie hardkoduj wartości
   w komponentach.
4. Zależności dodawaj tylko przez `libs.versions.toml` (version catalog) — nie
   wersje jawne w `build.gradle.kts`, żeby uniknąć mismatchy z BOM-em Compose.
