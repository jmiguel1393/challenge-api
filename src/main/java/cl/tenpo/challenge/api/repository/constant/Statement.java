package cl.tenpo.challenge.api.repository.constant;

public class Statement {
    public static final String LOG_SEARCH_STATEMENT = "SELECT rq.method AS method, rq.path AS path, rq.parameters AS parameters, "
            + "rq.body AS requestBody, rq.created_at AS requestDate, "
            + "rq.headers AS requestHeaders, "
            + "rs.body AS responseBody, rs.created_at AS responseDate, "
            + "rs.headers AS responseHeaders "
            + "FROM request_logs rq INNER JOIN response_logs rs "
            + "ON rq.uuid = rs.uuid ";

    public static final String RESPONSE_LOG_SEARCH_STATEMENT = "SELECT body FROM response_logs WHERE "
            + "method = :method AND path = :path "
            + "ORDER BY created_at DESC LIMIT 1";
}
