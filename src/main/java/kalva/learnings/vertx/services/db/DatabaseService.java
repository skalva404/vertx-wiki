package kalva.learnings.vertx.services.db;

import java.util.HashMap;
import java.util.List;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import kalva.learnings.vertx.multiverticles.SqlQuery;

@ProxyGen
public interface DatabaseService {

  @Fluent
  DatabaseService fetchAllPages(Handler<AsyncResult<JsonArray>> resultHandler);

  @Fluent
  DatabaseService fetchPage(String name, Handler<AsyncResult<JsonObject>> resultHandler);

  @Fluent
  DatabaseService createPage(String title, String markdown, Handler<AsyncResult<Void>> resultHandler);

  @Fluent
  DatabaseService savePage(int id, String markdown, Handler<AsyncResult<Void>> resultHandler);

  @Fluent
  DatabaseService deletePage(int id, Handler<AsyncResult<Void>> resultHandler);

  @Fluent
  DatabaseService fetchAllPagesData(Handler<AsyncResult<List<JsonObject>>> resultHandler);

  @Fluent
  DatabaseService fetchPageById(int id, Handler<AsyncResult<JsonObject>> resultHandler);

  static DatabaseService create(JDBCClient dbClient, HashMap<SqlQuery, String> sqlQueries,
                                Handler<AsyncResult<DatabaseService>> readyHandler) {
    return new DatabaseServiceImpl(dbClient, sqlQueries, readyHandler);
  }

  static DatabaseService createProxy(Vertx vertx, String address) {
    return new DatabaseServiceVertxEBProxy(vertx, address);
  }
}
