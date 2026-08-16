# `:app`

Najcieńsza warstwa w projekcie — bez logiki domenowej, bez repozytoriów. Jedyna
odpowiedzialność: uruchomienie procesu (`ApkalypseApplication`, `MainActivity`),
start DI (Koin) i nawigacja (`NavHost`) między feature'ami.

## Zawartość (Faza 0)

- `ApkalypseApplication` — `startKoin { ... }`, na razie z pustą listą modułów;
  docelowo rozbudowywana w Fazie 8 o moduły Koin wszystkich featureów (przez `:core-di`).
- `MainActivity` — `setContent { APKalypseTheme { NavigationGraph() } }`, bez logiki własnej.
- `presentation/navigation/`
  - `AppDestination.kt` — trasy jako `@Serializable object` (`Home`, `Placeholder`),
    type-safe navigation zamiast surowych Stringów.
  - `NavigationGraph.kt` — `NavHost` przyjmujący `navController` jako parametr
    (domyślnie `rememberNavController()`), żeby dało się wstrzyknąć
    `TestNavHostController` w testach bez duplikowania grafu.
- `presentation/home/HomeScreen.kt` — "Demo list screen": statyczna lista
  (`featureList`), klik nawiguje przez `onFeaturePicked`.
- `presentation/PlaceholderScreen.kt` — placeholder pod docelowe trasy featureów
  (realne trasy dopiero w Fazie 8).

## Wymaga

- Plugin `kotlin("plugin.serialization")` (`libs.plugins.kotlin.serialization`) —
  niezbędny, żeby `@Serializable` na trasach faktycznie generowało serializer
  używany przez type-safe `composable<T>()`. Bez niego kompiluje się, ale wywala
  się w runtime (`SerializerNotFoundException`).

## Testy

`NavigationSanityTest` (`androidTest`) — weryfikuje, że `NavHost` startuje na
`Home`, renderuje "Demo list screen", i że kliknięcie pozycji nawiguje do
`Placeholder`. Używa gołego `createComposeRule()` (nie `createAndroidComposeRule`),
bo test sam wywołuje `setContent` z wstrzykniętym `TestNavHostController` —
`createAndroidComposeRule<MainActivity>()` uruchomiłby `MainActivity.onCreate()`
i ustawił content automatycznie, co koliduje z ręcznym `setContent` w teście.

## Czego tu nie ma (celowo)

- Realnych tras do featureów — dochodzą w Fazie 8 razem z integracją.
- Modułów Koin featureów — `:app` zna tylko `:core-di`, nie featury bezpośrednio.
- Jakiejkolwiek logiki biznesowej — to żyje w domain warstwach featureów.
