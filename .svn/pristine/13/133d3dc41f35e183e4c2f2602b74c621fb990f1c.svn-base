/***********************************************************************
 * Module:  RDBFactory.java
 * Author:  Jovic
 * Purpose: Defines the Class RDBFactory
 ***********************************************************************/

package infviewer.controller;

import infviewer.workspace.controller.RDBCRUD;
import infviewer.workspace.controller.RDBParser;

/**
 * {@inheritDoc}
 */
public class RDBFactory implements AbstractFactory {
   
   public Parser createParser() {
      RDBParser rdbparser = new RDBParser();
      return rdbparser;
   }
   
   public CRUD createCRUD() {
      RDBCRUD rdbcrud = new RDBCRUD();
      return rdbcrud;
   }
   
   public Validator createValidator() {
      return null;
   }
}