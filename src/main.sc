require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: /hello
        intent!: /привет
        a: Привет привет

    state: Bye
        intent!: /пока
        a: Пока пока

    state: /NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}

        
theme: /WeatherForecast
    
    state: /weather
        q!: * ~прогноз * ~погода *
        q!: * ~погода *
        q!: * ~прогноз *
        q!: *будет [осадк*/~дождь/~снег/~град]*
        a: Окей, вот прогноз погоды.
    
theme: /Banking
    
    state: /currency
        q!: * ~прогноз * ~валюта *
        q!: * ~курс * ~валюта *
        q!:*~валюта *
        q!: * ~курс *
        a: Окей, вот курс валюты.