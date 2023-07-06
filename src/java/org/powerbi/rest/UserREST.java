package org.powerbi.rest;
import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.powerbi.core.UserController;
import org.powerbi.model.User;
/**
 * @author Alex SP
 */
@Path("user")
public class UserREST {
    @Path("login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@FormParam("userData") @DefaultValue("") String userData) throws Exception{
        String out = "";
        Gson gson = new Gson();
        User u = new User();
        UserController uc = new UserController();
        u = gson.fromJson(userData,User.class);
        u = uc.login(u.getNombreUsuario(),u.getContrasenia());
        try {
        if(u != null){
            out = gson.toJson(u);
        }else{
            out="""
            {"error":"Datos de Credencial incorrectos"}
            """;
        }
        } catch (Exception e) {
            e.printStackTrace();
            out = """
                  {"exception":"?"}
                  """;
            out = String.format(out, e.toString());
        }
            return Response.status(Response.Status.OK).entity(out).build();
    }
}