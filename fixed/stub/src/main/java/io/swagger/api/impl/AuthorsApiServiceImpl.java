package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Author;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-07-25T13:54:03.657+03:00")
public class AuthorsApiServiceImpl extends AuthorsApiService {
    @Override
    public Response addAuthor(Integer id, String surname, String name, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
//        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        return Response.ok().entity(Util.addAuthor(id, surname, name)).build();
    }
    @Override
    public Response getAuthors(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
//        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        return Response.ok().entity(Util.getAuthors()).build();
    }
}
