public enum Color {
    ROJO("#FF0000"),
    AMARILLO("#FFFF00"),
    AZUL("#0000FF");

    private final String valorHexadecimal;

    Color(String valorHexadecimal) {
        this.valorHexadecimal = valorHexadecimal;
    }
    public String getValorHexadecimal() {
        return valorHexadecimal;
    }
}
// Define el enum 'Color' para representar los colores primarios: 
// ROJO, AMARILLO y AZUL. Cada constante del enum debe incluir una propiedad 
// adicional llamada 'valorHexadecimal', que represente el valor hexadecimal
//  del color. Los valores hexadecimales correspondientes son: ROJO = "#FF0000",
//   AMARILLO = "#FFFF00" y AZUL = "#0000FF". Posteriormente, crea la clase 
//   'ConvertidorColor', que contenga un método denominado 'convertirHexadecimal',
//    el cual tome como parámetro un valor hexadecimal. Este método deberá retornar
//     el color correspondiente del enum si existe. En caso contrario, retornará null.

// En tu clase 'Application', realiza pruebas con 5 colores ingresados,
//  verificando si son o no colores primarios. Si el color es válido, 
//  imprime el nombre del color; de lo contrario, imprime "No es un color primario".