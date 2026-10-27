# Serenity BDD + Screenplay — Demo Demoblaze

![Java](https://img.shields.io/badge/Java-17-blue)
![Serenity BDD](https://img.shields.io/badge/Serenity%20BDD-5.4.1-green)
![Cucumber](https://img.shields.io/badge/Cucumber-8.0.4-brightgreen)
![Gradle](https://img.shields.io/badge/Gradle-9.8.2-darkgreen)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

Flujo de compra completo contra [demoblaze.com](https://www.demoblaze.com): autenticación, selección
de productos, carrito, pago y verificación del mensaje de confirmación. Es la
[plantilla](https://github.com/cedaniel200/serenity-screenplay-template) con un caso real implementado.

## Qué demuestra

- **Screenplay completo**: `tasks`, `interactions`, `questions` y `userinterfaces` sobre un flujo de
  negocio con varias pantallas.
- **Un escenario de punta a punta**: iniciar sesión, agregar dos productos de categorías distintas,
  completar el pago y comprobar el mensaje de éxito con una aserción.
- **Esperas explícitas y manejo de alertas**: el sitio abre diálogos del navegador que hay que
  aceptar; el flujo los trata como parte del guion.
- **Lombok** para el modelo y un `PurchaserFactory` que construye los datos de compra.

## Requisitos

- **JDK 17**. El build fija un toolchain de Java 17.
- **Un navegador instalado** (Chrome por defecto). El driver lo resuelve Selenium Manager.
- **Conexión a internet**: el escenario se ejecuta contra un sitio público.

## Cómo se ejecuta

```sh
./gradlew test
./gradlew aggregate
```

El informe queda en `target/site/serenity/index.html`.

Para ejecutarlo sin abrir ventana:

```sh
./gradlew test -Dheadless.mode=true
```

La cuenta usada es la de demostración pública del sitio (`admin` / `admin`). No hay credenciales
reales en el repositorio.

## Estructura

```text
src/main/java/com/cedaniel200/automatizacion
├── tasks/            # Authenticate, Add, Buy
├── interactions/     # Resize
├── questions/        # PurchaseSuccessful
├── userinterfaces/   # LoginPage, DemoBlazeHomePage, ProductPage, CartPage, PlaceOrderPage, MenuPage
├── models/           # Credentials, Product, Purchaser, PurchaserFactory
└── exceptions/

src/test
├── java/.../runner/PurchaseTestSuite.java
├── java/.../stepdefinitions/PurchaseStepDefinitions.java
└── resources/
    ├── features/purchase.feature
    └── serenity.conf          # URL base y entornos
```

## Relación con la plantilla

Usa la estructura de [serenity-screenplay-template](https://github.com/cedaniel200/serenity-screenplay-template)
con el paquete ya adaptado al proyecto (`com.cedaniel200.automatizacion`). Añade `models`, que la
plantilla deja vacío a propósito.

La configuración vive en `serenity.conf`, no en `serenity.properties`: define `webdriver.base.url`
y los entornos `dev` y `prod`, este último con `headless.mode = true`.

## Docker

```sh
docker compose up --abort-on-container-exit
```

El navegador corre en el servicio `chrome` (imagen oficial de Selenium); los tests le envían
comandos por HTTP y no abren ninguna ventana en tu máquina. El informe queda en
`./target/site/serenity/`.

## Ten en cuenta

- **Depende de un sitio de terceros.** Si Demoblaze cambia sus identificadores o su flujo, el
  escenario se rompe. Los localizadores usan `id` y texto visible, que es lo más frágil del repo.
- **Crea pedidos de prueba** en el sitio. No hay datos personales reales.
- **`gradle.startParameter.continueOnFailure = true`**: Gradle sigue tras una tarea fallida. Está
  heredado y puede enmascarar errores en ejecuciones locales.

## Licencia

[MIT](LICENSE) © Cesar Daniel
