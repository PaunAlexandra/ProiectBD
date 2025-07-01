/** Clasa pentru exceptii
 * @author Paun Alexandra
 * @version 10 ianuarie 2025
 */

package com.mycompany.lista;

public class ListaNotFoundException extends Throwable {
    public ListaNotFoundException(String message) {
        super(message);
    }
}
