package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Wolkor
 */
public class DAOPosto {
       
    public List<Posto> getLista(){
        String sql = "select * from posto";
        List<Posto> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Posto obj = new Posto();
                obj.setCodigo(rs.getInt("codigo"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setCep(rs.getInt("cep"));
                obj.setBandeira(rs.getString("bandeira"));
                obj.setRazaoSocial(rs.getString("razaosocial"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setBairro(rs.getString("bairro"));
                obj.setNomePosto(rs.getString("nomeposto"));
                obj.setImagem(rs.getString("imagem"));
                lista.add(obj);                                
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro de SQL:"+e.getMessage());
        }
        return lista;
    }
    
    public boolean salvar(Posto obj){
        if(obj.getCodigo() == null){
            return incluir(obj);
        } else{
            return alterar(obj);
        }
    }
    
    public boolean incluir(Posto obj){
        String sql = "insert into posto(nomeposto,razaosocial,bandeira,endereco,bairro,cep,imagem,cnpj) values(?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNomePosto());
            pst.setString(2,obj.getRazaoSocial());
            pst.setString(3,obj.getBandeira());
            pst.setString(4,obj.getEndereco());
            pst.setString(5,obj.getBairro());
            pst.setInt(6,obj.getCep());
            pst.setString(7,obj.getImagem());
            pst.setString(8,obj.getCnpj());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Posto incluido com sucesso.");
                return true;
            } else{
                JOptionPane.showMessageDialog(null,"Posto não incluido com sucesso.");
                return false;
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro de SQL:"+e.getMessage());
            return false;
        }
    }
    
    public boolean alterar(Posto obj){
        String sql = "update posto set nomeposto = ?, razaosocial = ?, bandeira = ?, "
                + "endereco = ?, bairro = ?, cep = ?, imagem = ?,cnpj = ? where codigo = ?";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNomePosto());
            pst.setString(2,obj.getRazaoSocial());
            pst.setString(3,obj.getBandeira());
            pst.setString(4,obj.getEndereco());
            pst.setString(5,obj.getBairro());
            pst.setInt(6,obj.getCep());
            pst.setString(7,obj.getImagem());
            pst.setString(8,obj.getCnpj());
            pst.setInt(9, obj.getCodigo());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Posto alterado com sucesso.");
                return true;
            } else{
                JOptionPane.showMessageDialog(null,"Posto não alterado com sucesso.");
                return false;
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro de SQL:"+e.getMessage());
            return false;
        }
    }
    
    public boolean remover(Posto obj){
        String sql = "delete from posto where codigo = ?";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodigo());
            if(pst.executeUpdate() > 0){
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
    
    public List<Posto> localizar (String str){
        String sql = "select * from posto where bairro = ?";
        List<Posto> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1,str);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Posto obj = new Posto();
                obj.setCodigo(rs.getInt("codigo"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setCep(rs.getInt("cep"));
                obj.setBandeira(rs.getString("bandeira"));
                obj.setRazaoSocial(rs.getString("razaosocial"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setBairro(rs.getString("bairro"));
                obj.setNomePosto(rs.getString("nomeposto"));
                obj.setImagem(rs.getString("imagem"));
                lista.add(obj);                                
            }      
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de SQL:"+e.getMessage());           
        }
        return lista;
    }
    
}
