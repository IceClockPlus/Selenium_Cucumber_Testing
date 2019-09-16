 Feature: Realizar transferencia entre cuentas
   
   Scenario: Realizar transferencia correctamente
    Given Navegar hasta la url ruralvia "https://www.ruralvia.com/demos/demo_V2_0/default.html"
    When Indicar el usuario "//*[@id='CAJA']/center/table[2]/tbody/tr[2]/td[2]/input" como "02000008"
    And Indicar el password "//*[@id='CAJA']/center/table[2]/tbody/tr[3]/td[2]/input"  como "12345"
    And  Hacer click en Entrar "//*[@id='BOT']/a"
    And  Seleccionar contrato cuenta "//*[@id='TrColor']/td[1]/a"
    And  Click en el link de transferencia "Transferencias"
    And  Indicar la cuenta de cargo "SELCTA"
    And  Indica la cuenta beneficiaria "//*[@id='BODY_INPUT']/table/tbody/tr[1]/td[2]/select"
    And Click en el link aceptar "//*[@id='BOT']/a"
    Then el importe enviado debe ser al importe recibido  
    
    Scenario: Realizar transferencia sin seleccionar la cuenta
    Given al navegar hasta la url "https://www.ruralvia.com/demos/demo_V2_0/default.html"
    When coloca en el campo usuario "//*[@id='CAJA']/center/table[2]/tbody/tr[2]/td[2]/input" el texto "02000008"
    And coloca en el campo password "//*[@id='CAJA']/center/table[2]/tbody/tr[3]/td[2]/input" el texto "12345"
    And  hacer click sobre el boton Entrar "//*[@id='BOT']/a"
    And  seleccionar contrato "//*[@id='TrColor']/td[1]/a"
    And  hacer click en el link de transferencia "Transferencias"
    And  hacer click en el link aceptar "//*[@id='BOT']/a"
    Then Presenta el mensaje de alerta 