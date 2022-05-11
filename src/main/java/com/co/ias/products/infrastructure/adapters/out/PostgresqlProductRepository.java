package com.co.ias.products.infrastructure.adapters.out;

import com.co.ias.products.products.application.domain.Product;
import com.co.ias.products.products.application.domain.ProductId;
import com.co.ias.products.products.application.models.ProductDBO;
import com.co.ias.products.products.application.ports.out.ProductRepository;
import com.co.ias.products.shared.domain.PageQuery;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class PostgresqlProductRepository implements ProductRepository {

    private final DataSource dataSource;

    public PostgresqlProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void store(Product product) {
        String sql = "INSERT INTO products (id, name, type_of_product, price) VALUES (?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, product.getProductId().getValue());
            preparedStatement.setString(2, product.getProductName().toString());
            preparedStatement.setInt(3, product.getTypeOfProduct().getValue());
            preparedStatement.setLong(4, product.getProductPrice().getValue());

            preparedStatement.execute();

        } catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }
    }

    @Override
    public Optional<Product> get(ProductId productId) {
        String sql = "Select * From products Where id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, productId.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ProductDBO productDBO = ProductDBO.fromResultSet(resultSet);
                Product product = productDBO.toDomain();
                return Optional.of(product);
            } else {
                return Optional.empty();
            }

        }catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(ProductId productId) {

    }

    @Override
    public List<Product> getProducts(PageQuery pageQuery) {
        return null;
    }
}
