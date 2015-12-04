package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Wolkor
 */
public class DAOCombustiveis {
    public List<Combustiveis> getLista(){
        String sql = "select * from cidades";
        List<Combustiveis> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Combustiveis obj = new Combustiveis();
                obj.setCodigo(rs.getInt("codigo"));               
                java.sql.Date dt = rs.getDate("datapreco");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                obj.setDataDePrecos(c);
                obj.setValorGasolina(rs.getFloat("precocomum"));
                obj.setValorGasolinaAd(rs.getFloat("precoad"));
                obj.setValorAlcool(rs.getFloat("precoetanol"));
                obj.setValorDisel(rs.getFloat("precodiesel"));
                lista.add(obj);
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro de SQL:"+e.getMessage());
        }
        return lista;
    }
    
    public boolean salvar(Combustiveis obj){
        if(obj.getCodigo() == null){
            return incluir(obj);
        } else{
            return alterar(obj);
        }
    }
    
    public boolean incluir(Combustiveis obj){
        String sql = "insert into precocombustiveis (datapreco,precocomum,precoad,"
                + "precoetanol,precodiesel,idPosto,codigo) valeus(?,?,?,?,?,?,?)";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setDate(1, new java.sql.Date(obj.getDataDePrecos().getTimeInMillis()));
            pst.setFloat(2, obj.getValorGasolina());
            pst.setFloat(3, obj.getValorGasolinaAd());
            pst.setFloat(4, obj.getValorAlcool());
            pst.setFloat(5, obj.getValorDisel());
            pst.setInt(6,obj.getIdPosto());                   
            pst.setInt(7, obj.getCodigo());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Atualização incluida com sucesso.");
                return true;
            } else{
                JOptionPane.showMessageDialog(null,"Não foi possivel completar a inclusão.");
                return false;
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro de SQL:"+e.getMessage());
            return false;
        }
    }
    
    public boolean alterar(Combustiveis obj){
        String sql = "update posto set datapreco = ?, precocomum = ?, precoad = ?,"
                + " precoetanol = ?, precodiesel = ?, idPosto = ? where codigo = ?";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setDate(1, new java.sql.Date(obj.getDataDePrecos().getTimeInMillis()));
            pst.setFloat(2, obj.getValorGasolina());
            pst.setFloat(3, obj.getValorGasolinaAd());
            pst.setFloat(4, obj.getValorAlcool());
            pst.setFloat(5, obj.getValorDisel());
            pst.setInt(6,obj.getIdPosto());                   
            pst.setInt(7, obj.getCodigo());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Preços alterados com sucesso.");
                return true;
            } else{
                JOptionPane.showMessageDialog(null,"Preços não alterados com sucesso.");
                return false;
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro de SQL:"+e.getMessage());
            return false;
        }
    }
    
    
    public boolean remover(Combustiveis obj){
        String sql = "delete from precocombustiveis where codigo = ?";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodigo());
            if(pst.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Excluido com sucesso:");
                return true;
            } else{
                JOptionPane.showMessageDialog(null, "Sem sucesso na exclusão:");
                return false;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de SQL:"+e.getMessage());
            return false;
        }
    } 
    
    public List<Combustiveis> buscaCombustiveis(List<Combustiveis> combustiveis){
        List<Combustiveis> listaCombustiveis = new ArrayList<>();
        listaCombustiveis.addAll(Dados.listaCombustiveis);
        listaCombustiveis.retainAll(combustiveis);
        return listaCombustiveis;
    }
    
    public Combustiveis localizar (Integer id){
        String sql = "select * from precocombustiveis where codigo = ?";
        Combustiveis obj = new Combustiveis();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodigo());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){              
                obj.setCodigo(rs.getInt("codigo"));               
                java.sql.Date dt = rs.getDate("datapreco");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                obj.setDataDePrecos(c);
                obj.setValorGasolina(rs.getFloat("precocomum"));
                obj.setValorGasolinaAd(rs.getFloat("precoad"));
                obj.setValorAlcool(rs.getFloat("precoetanol"));
                obj.setValorDisel(rs.getFloat("precodiesel"));
                return obj;
            }       
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de SQL:"+e.getMessage());           
        }
        return null;
    }   
    
    public List<Combustiveis> consulta(Integer id){
        String sql = "select * from precocombustiveis where posto = ?";
        List<Combustiveis> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Combustiveis obj = new Combustiveis();
                obj.setCodigo(rs.getInt("codigo"));               
                java.sql.Date dt = rs.getDate("datapreco");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                obj.setDataDePrecos(c);
                obj.setValorGasolina(rs.getFloat("precocomum"));
                obj.setValorGasolinaAd(rs.getFloat("precoad"));
                obj.setValorAlcool(rs.getFloat("precoetanol"));
                obj.setValorDisel(rs.getFloat("precodiesel"));
                lista.add(obj);
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro de SQL:"+e.getMessage());
        }
        return lista;
    }
    
}
