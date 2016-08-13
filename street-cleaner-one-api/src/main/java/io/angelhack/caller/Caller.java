package io.angelhack.caller;

import io.angelhack.rest.pojo.ResponseScenario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Caller {
    public static void call(String number) {
        System.out.println(number);

        if (number.startsWith("8")) {
            number = number.replaceFirst("8", "+7");
        }

        RestTemplate restTemplate = new RestTemplate();

        StringBuilder startScenarios = new StringBuilder("https://api.voximplant.com/platform_api/StartScenarios/?account_id=" +
                530063 + "&api_key=" +
                "2bc17e3d-8bb9-4b94-bae7-a8b342e87e64" + "&rule_id=201263"
                + "&script_custom_data=" + number);

        ResponseEntity<ResponseScenario> responseScenario =
                restTemplate.getForEntity(startScenarios.toString(), ResponseScenario.class);

        System.out.println("Результат выполнения сценария:");
        System.out.println(responseScenario);
    }
}
