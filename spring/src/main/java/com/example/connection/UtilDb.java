package com.example.connection;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import jakarta.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

public class UtilDb implements DataSource {
    private final DataSource delegate;

    public UtilDb(DataSource delegate) {
        this.delegate = delegate;
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = delegate.getConnection();
        if (connection != null) {
            System.out.println("Connection to database succeeded via HikariCP.");
        }
        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        Connection connection = delegate.getConnection(username, password);
        if (connection != null) {
            System.out.println("Connection to database succeeded via HikariCP with provided credentials.");
        }
        return connection;
    }

    @PreDestroy
    public void shutdown() {
        if (delegate instanceof HikariDataSource) {
            ((HikariDataSource) delegate).close();
            System.out.println("HikariCP DataSource closed successfully.");
        }
    }

    // Required DataSource methods
    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return delegate.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return delegate.isWrapperFor(iface);
    }

    @Override
    public java.io.PrintWriter getLogWriter() throws SQLException {
        return delegate.getLogWriter();
    }

    @Override
    public void setLogWriter(java.io.PrintWriter out) throws SQLException {
        delegate.setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        delegate.setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return delegate.getLoginTimeout();
    }

    @Override
    public java.util.logging.Logger getParentLogger () throws SQLFeatureNotSupportedException{
        return delegate.getParentLogger();
    }
}