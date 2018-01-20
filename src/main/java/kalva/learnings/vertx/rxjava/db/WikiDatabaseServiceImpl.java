package kalva.learnings.vertx.rxjava.db;

import java.util.HashMap;
import java.util.List;

import static kalva.learnings.vertx.multiverticles.SqlQuery.CREATE_PAGES_TABLE;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.rx.java.RxHelper;
import io.vertx.rxjava.ext.jdbc.JDBCClient;
import io.vertx.rxjava.ext.sql.SQLConnection;
import kalva.learnings.vertx.multiverticles.SqlQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Single;

public class WikiDatabaseServiceImpl implements WikiDatabaseService {


  private static final Logger LOGGER = LoggerFactory.getLogger(WikiDatabaseServiceImpl.class);

  private final HashMap<SqlQuery, String> sqlQueries;
  private final JDBCClient dbClient;

  public WikiDatabaseServiceImpl(io.vertx.ext.jdbc.JDBCClient dbClient,
                                 HashMap<SqlQuery, String> sqlQueries,
                                 Handler<AsyncResult<WikiDatabaseService>> readyHandler) {

    this.dbClient = new JDBCClient(dbClient);
    this.sqlQueries = sqlQueries;

    getConnection()
      .flatMap(conn -> conn.rxExecute(sqlQueries.get(CREATE_PAGES_TABLE)))
      .map(v -> this)
      .subscribe(RxHelper.toSubscriber(readyHandler));
  }

  private Single<SQLConnection> getConnection() {
    return dbClient.rxGetConnection().flatMap(conn -> {
      Single<SQLConnection> connectionSingle = Single.just(conn);
      return connectionSingle.doOnUnsubscribe(conn::close);
    });
  }

  @Override
  public WikiDatabaseService fetchAllPages(Handler<AsyncResult<JsonArray>> resultHandler) {
    return null;
  }

  @Override
  public WikiDatabaseService fetchPage(String name, Handler<AsyncResult<JsonObject>> resultHandler) {
    return null;
  }

  @Override
  public WikiDatabaseService fetchPageById(int id, Handler<AsyncResult<JsonObject>> resultHandler) {
    return null;
  }

  @Override
  public WikiDatabaseService createPage(String title, String markdown, Handler<AsyncResult<Void>> resultHandler) {
    return null;
  }

  @Override
  public WikiDatabaseService savePage(int id, String markdown, Handler<AsyncResult<Void>> resultHandler) {
    return null;
  }

  @Override
  public WikiDatabaseService deletePage(int id, Handler<AsyncResult<Void>> resultHandler) {
    return null;
  }

  @Override
  public WikiDatabaseService fetchAllPagesData(Handler<AsyncResult<List<JsonObject>>> resultHandler) {
    return null;
  }
}
