package tests;

import java.lang.reflect.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 Teste de integridade estrutural do modelo.
 
  Este teste garante que NENHUMA modificação indevida seja feita nas
  classes essenciais do sistema. Ele é usado como mecanismo de segurança:
  se alguém alterar atributos, métodos, tipos ou remover partes críticas,
  a compilação falha imediatamente.
 
  Isso protege o modelo de domínio do app de controle de gastos.
 */
public class TesteIntegridade {

   
    // 1. Verifica classe Usuario
    @Test
    public void testarClasseUsuario() throws Exception {

        Class<?> c = Class.forName("minhasfinancas.Usuario");

        // Atributos obrigatórios
        assertNotNull(c.getDeclaredField("nome"));
        assertEquals(String.class, c.getDeclaredField("nome").getType());

        assertNotNull(c.getDeclaredField("dataNascimento"));

        assertNotNull(c.getDeclaredField("cpf"));
        assertEquals(String.class, c.getDeclaredField("cpf").getType());

        assertNotNull(c.getDeclaredField("perfilInvestidor"));
        assertEquals(String.class, c.getDeclaredField("perfilInvestidor").getType());

        assertNotNull(c.getDeclaredField("email"));
        assertEquals(String.class, c.getDeclaredField("email").getType());

        // Métodos obrigatórios
        assertNotNull(c.getMethod("mostrarDados"));
        assertNotNull(c.getMethod("listarContasBanco"));
        assertNotNull(c.getMethod("vincularContaBanco", Class.forName("minhasfinancas.ContaBanco")));
    }

    
    // 2. Verifica classe Conta (abstrata)
    @Test
    public void testarClasseConta() throws Exception {

        Class<?> c = Class.forName("minhasfinancas.Conta");

        assertTrue(Modifier.isAbstract(c.getModifiers()));

        assertNotNull(c.getDeclaredField("id"));
        assertEquals(int.class, c.getDeclaredField("id").getType());

        assertNotNull(c.getDeclaredField("pais"));
        assertEquals(String.class, c.getDeclaredField("pais").getType());

        assertNotNull(c.getDeclaredField("saldo"));
        assertEquals(double.class, c.getDeclaredField("saldo").getType());
    }

    
    // 3. Verifica classe ContaBanco
    @Test
    public void testarClasseContaBanco() throws Exception {

        Class<?> c = Class.forName("minhasfinancas.ContaBanco");

        assertNotNull(c.getDeclaredField("agencia"));
        assertEquals(int.class, c.getDeclaredField("agencia").getType());

        assertNotNull(c.getDeclaredField("numeroConta"));
        assertEquals(int.class, c.getDeclaredField("numeroConta").getType());

        assertNotNull(c.getMethod("gerarDashboard"));
    }

    
    // 4. Verifica classe ContaCorretora
    @Test
    public void testarClasseContaCorretora() throws Exception {

        Class<?> c = Class.forName("minhasfinancas.ContaCorretora");

        assertNotNull(c.getDeclaredField("corretora"));
        assertEquals(String.class, c.getDeclaredField("corretora").getType());
    }


    // 5. Verifica classe Transacao
    @Test
    public void testarClasseTransacao() throws Exception {

        Class<?> c = Class.forName("minhasfinancas.Transacao");

        assertNotNull(c.getDeclaredField("valor"));
        assertEquals(double.class, c.getDeclaredField("valor").getType());

        assertNotNull(c.getDeclaredField("categoria"));
        assertEquals(String.class, c.getDeclaredField("categoria").getType());

        assertNotNull(c.getDeclaredField("data"));

        assertNotNull(c.getMethod("mostrarTransacao"));
    }

    
    // 6. Verifica classe Investimento
    @Test
    public void testarClasseInvestimento() throws Exception {

        Class<?> c = Class.forName("minhasfinancas.Investimento");

        assertNotNull(c.getDeclaredField("nome"));
        assertNotNull(c.getDeclaredField("valorAplicado"));
        assertEquals(double.class, c.getDeclaredField("valorAplicado").getType());

        assertNotNull(c.getMethod("mostrarInvestimento"));
    }
}

