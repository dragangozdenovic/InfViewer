package infviewer.controller;

import infviewer.tree.model.Package;
/**
 * <code>Parser</code> interfejs predstvlja apstrakciju Parsera nezavisnog od konkretne implementacije.
 * Sadrzi metodu <code>parse</code> za parsiranje objekata.

 * @author Tim9.1
 * @version 1.0
 * @see infviewer.tree.controller.JSONParser
 * @see infviewer.workspace.controller.RDBParser
 */
public interface Parser {
    /**
     * Klasa koja implementira {@code Parser} interfejs pomoću parse metode vrši parsiranje.
     * U okviru same metode se kreira paket {@code Package} unutar koga se smešta isparsirani objekat koji je prosleđen metodi.
     * @param object Objekat nad kojim se vrši parsiranje.
     * @return paket {@code Package} u kom je smešten isparsirani objekat. Ukoliko prosleđeni objekat nije odgovarajući vraća prazan paket.
     */
   Package parse(Object object);
}