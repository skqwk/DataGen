## DataGen Frontend

В данной части проекта - клиентская часть DataGen

```Json
    let r = {
        name: "student",
        fields: [ 
            {
                name: "age",
                type: "int",
                details: {
                    range: [10, 20]
                }
            },

            {
                name: "name",
                type: "text",
            }
        ]
    }
```