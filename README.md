# Norte4j Countdown ⏱️

Um aplicativo Android nativo desenvolvido em **Kotlin** com **Jetpack Compose** que fornece uma interface elegante e funcional para contagem regressiva de tempo.

## 📋 Descrição

CountDown é um aplicativo de contagem regressiva minimalista e intuitivo. Oferece uma experiência visual moderna com um timer digital em estilo retrô, perfeito para gerenciar timeouts, pausas ou qualquer atividade que exija controle de tempo.

## ✨ Características

- ⏱️ **Timer Digital Estilizado**: Display em fonte digital retrô (Digital-7)
- ⏯️ **Controle Completo**: Iniciar, pausar, retomar e resetar a contagem
- 🎨 **Interface Moderna**: Desenvolvido com Jetpack Compose e Material 3
- 📱 **Edge-to-Edge**: Aproveita toda a tela do dispositivo
- ⚡ **Reativo**: Usa StateFlow e Coroutines para atualizações fluidas
- 🔄 **MVVM**: Arquitetura limpa e testável

## 🛠️ Tecnologias

### Stack Técnico
- **Linguagem**: Kotlin
- **Framework UI**: Jetpack Compose
- **Arquitetura**: MVVM (Model-View-ViewModel)
- **Gerenciamento de Estado**: StateFlow & Coroutines
- **Compilação**: Gradle com KTS
- **SDK Android**: Mínimo 24, Alvo 36

### Dependências Principais
- `androidx.lifecycle:lifecycle-viewmodel-compose` - ViewModel com Compose
- `androidx.compose.*` - Jetpack Compose (UI, Graphics, Material 3)
- `androidx.activity:activity-compose` - Activity Compose integration
- `androidx.core:core-ktx` - Extensões do Android Core

## 📦 Estrutura do Projeto

```
CountDown/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/br/com/psdit/countdown/
│   │   │   │   ├── MainActivity.kt              # Activity principal
│   │   │   │   ├── CountdownScreen.kt           # UI principal (Compose)
│   │   │   │   ├── CountdownViewModel.kt        # ViewModel com lógica
│   │   │   │   ├── DigitalTimer.kt              # Componente timer
│   │   │   │   └── ui/theme/                    # Tema da aplicação
│   │   │   ├── res/                             # Recursos (fonts, drawables, etc)
│   │   │   └── AndroidManifest.xml
│   │   ├── test/
│   │   └── androidTest/
│   ├── build.gradle.kts                         # Configuração da aplicação
│   └── proguard-rules.pro
├── gradle/
│   └── libs.versions.toml                       # Gerenciamento de versões
├── build.gradle.kts                             # Build raiz
├── settings.gradle.kts                          # Configuração do projeto
└── README.md
```

## 🎯 Componentes Principais

### MainActivity.kt
- Activity principal da aplicação
- Ativa o modo edge-to-edge
- Configura o tema CountDownTheme
- Renderiza o CountdownScreen

### CountdownScreen.kt
- Composable principal da UI
- Layout com Scaffold e Material 3
- Exibe o timer digital
- Botões de controle: Reset, Pause, Continue
- Integração com ViewModel

### CountdownViewModel.kt
- Gerencia a lógica da contagem regressiva
- Usa `MutableStateFlow` para estado reativo
- Implementa coroutines para contagem de 1 segundo
- Funções públicas:
  - `startCountdown()` - Inicia a contagem
  - `pause()` - Pausa a contagem
  - `resume()` - Retoma a contagem
  - `reset(seconds)` - Reseta para um tempo específico (padrão: 45 minutos)

### DigitalTimer.kt
- Componente visual do timer
- Utiliza fonte customizada "Digital-7"
- Exibe tempo no formato `HH:MM:SS`
- Cor branca em fundo roxo

## 🚀 Começando

### Pré-requisitos
- Android Studio Hedgehog ou superior
- JDK 11+
- Android SDK com API 36

### Instalação

1. **Clone o repositório**
   ```bash
   git clone https://github.com/psdit/CountDown.git
   cd CountDown
   ```

2. **Abra o projeto no Android Studio**
   ```bash
   File > Open > (selecione o diretório do projeto)
   ```

3. **Sincronize o Gradle**
   - Android Studio vai sincronizar automaticamente
   - Ou use: `./gradlew sync`

### Build e Execução

#### Via Android Studio
1. Conecte um dispositivo ou inicie um emulador
2. Clique em "Run" ou pressione `Shift + F10`

#### Via Terminal
```bash
./gradlew assembleDebug          # Build APK debug
./gradlew installDebug           # Instala em dispositivo/emulador
./gradlew runDebug               # Build + Install + Launch
```

## 📖 Como Usar

1. **Iniciar App**: A contagem começa automaticamente com 45 minutos (2700 segundos)
2. **Pausar**: Clique no botão "Pause" para suspender a contagem
3. **Continuar**: Clique em "Continue" para retomar
4. **Resetar**: Clique em "Reset" para voltar ao tempo inicial

## ���� Testes

O projeto inclui configuração para:

```bash
# Testes unitários
./gradlew testDebug

# Testes instrumentados (Android)
./gradlew connectedDebugAndroidTest

# Todos os testes
./gradlew test connectedAndroidTest
```

## 🔧 Configuração

### Versões
- **App Version**: 1.0
- **Version Code**: 1
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 36 (Android 15)
- **Compile SDK**: 36

### Gradle Build System
O projeto usa **Gradle com Kotlin DSL (KTS)** para melhor type-safety e IDE support.

## 🎨 Customizações

### Alterar Tempo Inicial
No arquivo `CountdownViewModel.kt`:
```kotlin
private val _timeLeft = MutableStateFlow(45 * 60) // Altere este valor
```

### Alterar Cores
No arquivo `CountdownScreen.kt`, modifique o `Purple80` para suas cores preferidas no tema.

### Alterar Fonte
Substitua o arquivo `digital_7.ttf` em `res/font/` por outra fonte desejada.

## 📱 Compatibilidade

- **Android**: 7.0 (API 24) até versão mais recente
- **Orientação**: Retrato (pode ser expandido)
- **Tamanhos de Tela**: Adaptável para phones e tablets

## 🏗️ Arquitetura

```
┌─────────────────┐
│   MainActivity  │
└────────┬────────┘
         │
    setContent()
         │
┌────────▼──────────────────┐
│   CountDownTheme          │
│   └─ CountdownScreen()    │
│      ├─ Scaffold          │
│      └─ DigitalTimer()    │
└────────┬──────────────────┘
         │ viewModel()
┌────────▼──────────────────┐
│  CountdownViewModel       │
│  ├─ timeLeft: StateFlow   │
│  ├─ startCountdown()      │
│  ├─ pause()               │
│  └─ resume()              │
└───────────────────────────┘
```

## 📄 Licença

Este projeto é propriedade da PSDIT. Todos os direitos reservados.

## 👥 Contribuições

Contribuições são bem-vindas! Por favor:

1. Faça um Fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 🐛 Reportar Bugs

Se encontrar bugs, por favor abra uma issue descrevendo:
- O comportamento esperado
- O comportamento atual
- Passos para reproduzir
- Screenshots (se aplicável)

## 📞 Suporte

Para dúvidas ou sugestões, entre em contato através das issues do projeto.

---

**Desenvolvido com ❤️ pela PSDIT**

