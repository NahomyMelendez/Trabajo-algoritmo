/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoalgoritmo2;

import java.util.ArrayList;

/**
 *
 * @author Personal
 */
public class Arbolito {

    private Nodo node;

    public Arbolito() {
        node = null;
    }

    public Nodo retornaraiz() {
        return (node);
    }

    public synchronized void insertarNodo(Persona person) {
        if (node == null) {
            node = new Nodo(person);
            System.out.println("Se agrego la raíz: " + person.getCedula());
        }
    }

    public synchronized void getInOrden(Nodo raiz) {

        if (raiz.li != null) {
            getInOrden(raiz.li);
        }
        System.out.print(" " + raiz.person);

        if (raiz.ld != null) {
            getInOrden(raiz.ld);
        }

        System.out.print("" + raiz.ld);

    }

    public synchronized void getPreOrden(Nodo raiz) {
        if (raiz.li != null) {
            getPreOrden(raiz.li);
        }
        System.out.print(raiz.li);

        if (raiz.ld != null) {
            getPreOrden(raiz.ld);
        }
        System.out.print(raiz.ld);
    }

    public synchronized void getPostOrden(Nodo raiz) {
        if (raiz.li != null) {
            getPostOrden(raiz.li);
        }

        System.out.print(raiz.li);

        if (raiz.ld != null) {
            getPostOrden(raiz.ld);
        }
        System.out.print(raiz.ld);
    }

    public synchronized void getHoja(Nodo raiz) {

        if (raiz.li == null && raiz.ld == null) {
            System.out.print("hoja: " + raiz.person);
        }

        if (raiz.li != null) {
            getHoja(raiz.li);
        }
        if (raiz.ld != null) {
            getHoja(raiz.ld);
        }

    }

    public ArrayList<String> obtenerPersonasPorCedula(String cedula) {
        ArrayList<String> lista = new ArrayList<>();
        if (node != null) {
            node.busquedaPorCedula(lista, cedula);
        }
        return lista;
    }

    public void eliminarPorCedula(String cedula) {
        node = eliminarNodo(node, cedula);
    }

    private Nodo eliminarNodo(Nodo raiz, String cedula) {
        if (raiz == null) {
            return raiz;
        }

        if (cedula.compareTo(raiz.person.getCedula()) < 0) {
            raiz.li = eliminarNodo(raiz.li, cedula);
        } else if (cedula.compareTo(raiz.person.getCedula()) > 0) {
            raiz.ld = eliminarNodo(raiz.ld, cedula);
        } else {
            if (raiz.li == null && raiz.ld == null) {
                return null;
            }
            if (raiz.li == null) {
                return raiz.ld;
            } else if (raiz.ld == null) {
                return raiz.li;
            }

            raiz.person = encontrarMinimo(raiz.ld).person;
            raiz.ld = eliminarNodo(raiz.ld, raiz.person.getCedula());
        }
        return raiz;
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.li != null) {
            nodo = nodo.li;
        }
        return nodo;
    }
    }
