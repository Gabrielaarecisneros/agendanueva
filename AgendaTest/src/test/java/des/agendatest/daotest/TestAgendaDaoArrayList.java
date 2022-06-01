/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package des.agendatest.daotest;


import ed.agenda.dao.AgendaDaoArrayList;
import ed.agenda.entidades.Contacto;
import ed.agenda.entidades.ContactoEmpresa;
import ed.agenda.entidades.ContactoPersona;
import ed.agenda.excepciones.ContactoNoEncontradoException;
import ed.agenda.excepciones.PosicionNoEncontradaException;
import static java.awt.PageAttributes.MediaType.A;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author marco
 */
public class TestAgendaDaoArrayList {

    AgendaDaoArrayList dao;

    @Before //limpia el array de Agenda antes de ejecutar cada test
    public void borrarAgenda() {
        dao = new AgendaDaoArrayList();
        dao.setContactos(new ArrayList<Contacto>());

    }

    @Test
    public void TestCrearContactoPersona() {

        ContactoPersona CP1 = new ContactoPersona("11221999", "BillGates", "+34 981 666666");
        AgendaDaoArrayList dao = new AgendaDaoArrayList();

        //Verifico que la agenda esta vacia
        assertTrue(dao.getContactos().isEmpty());
        //Añado el cotnacto persona
        dao.crearContactoPersona(CP1);

        //Verifico que la agenda contiene el contacto que yo he añadido
        assertTrue(dao.getContactos().contains(CP1));
        //Verificao que la agenda a aumentado su catidad de cotnactos en 1
        assertTrue(dao.getContactos().size() == 1);

    }

    @Test
    public void TestCrearContactoEmpresa() {

        ContactoEmpresa CE2 = new ContactoEmpresa("www.microsoft.com", "Microsoft", "789789987");
        AgendaDaoArrayList dao = new AgendaDaoArrayList();

        assertTrue(dao.crearContactoEmpresa(CE2));
        //Añado el cotnacto empresa
        dao.crearContactoEmpresa(CE2);

        //Verificao que la agenda a aumentado su catidad de cotnactos en 1
        
        assertTrue(dao.getContactos().size() == 1);
        	

    }

    @Test
    public void TestBorrarContactoPorPosicion() throws PosicionNoEncontradaException {

        ContactoPersona CP1 = new ContactoPersona("11221999", "BillGates", "+34 981 666666");
        AgendaDaoArrayList dao = new AgendaDaoArrayList();

        //Verifico que la agenda esta vacia
        assertTrue(dao.obtenerContactoPorNombre("BillGates") == null);

        dao.crearContactoPersona(CP1);

        assertEquals(CP1, dao.obtenerContactoPorNombre("BillGates"));

        dao.borrarContactoPorPosicion(0);

        assertTrue(dao.obtenerContactoPorNombre("BillGates") == null);

    }

    @Test
    public void TestEliminarContactoPorNombre() throws ContactoNoEncontradoException {

        ContactoEmpresa CE2 = new ContactoEmpresa("www.microsoft.com", "Microsoft", "789789987");
        AgendaDaoArrayList dao = new AgendaDaoArrayList();

        assertTrue(dao.crearContactoEmpresa(CE2));
        //Añado el cotnacto empresa
        dao.crearContactoEmpresa(CE2);
        assertEquals(CE2, dao.obtenerContactoPorNombre("Microsoft"));
        
        //Verificao que la agenda a aumentado su catidad de cotnactos en 1
        assertTrue(dao.getContactos().size() == 1);
        
        dao.eliminarContactoPorNombre("Microsoft");
        assertTrue(dao.getContactos().remove(CE2));
       // assertTrue(dao.getContactos().size() == 1);
    }
    
    @Test
    public void TestMostrarTrabajadoresEmpresa() throws ContactoNoEncontradoException {

        ContactoEmpresa CE2 = new ContactoEmpresa("www.microsoft.com", "Microsoft", "789789987");
        
        

        assertTrue(dao.crearContactoEmpresa(CE2));
        //Añado el cotnacto empresa
        dao.crearContactoEmpresa(CE2);
        //assertEquals(CE2, dao.obtenerContactoPorNombre("Microsoft"));
        assertFalse(dao.obtenerContactoPorNombre("Microsoft")==null);
        //Verificao que la agenda a aumentado su catidad de cotnactos en 1
        
        
        
       // assertTrue(dao.getContactos().size() == 1);
    }
}

/* @Test
    public void TestmostrarTrabajadoresEmpresa() throws ContactoNoEncontradoException, PosicionNoEncontradaException {
        
        ContactoEmpresa CE2 = new ContactoEmpresa("www.microsoft.com", "Microsoft", "789789987");
        ContactoPersona CP1 = new ContactoPersona("11221999", "BillGates", "+34 981 666666");
        CE2.setTrabajadores(new ArrayList<>(Arrays.asList(CP1)));
        
        //assertTrue(CE2.setTrabajadores("BillGates"));
        AgendaDaoArrayList dao = new AgendaDaoArrayList();
        dao.crearContactoEmpresa(CE2);
        dao.mostrarTrabajadoresEmpresa("BillGates");
       
       assertTrue(dao.getContactos().contains(CE2));
       
         //assertEquals(CE2, dao.mostrarTrabajadoresEmpresa("BillGates"));
        //Verifico que la agenda esta vacia
        //assertFalse(dao.getContactos().isEmpty());
        //Añado el cotnacto persona

        //Verifico que la agenda contiene el contacto que yo he añadido
        //assertTrue(dao.getContactos().contains(CP1));
        //Verificao que la agenda a aumentado su catidad de cotnactos en 1
        //assertTrue(dao.getContactos().size() ==  6);

    }*/
