package com.co.ias.products.infrastructure.adapters.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import com.co.ias.products.shared.domain.PageQuery;
import com.co.ias.products.types.application.domain.Type;
import com.co.ias.products.types.application.domain.TypeId;
import com.co.ias.products.types.application.models.TypeDBO;
import com.co.ias.products.types.application.ports.out.TypeRepository;

import org.springframework.stereotype.Repository;

@Repository
public class PostgresqlTypeRepository implements TypeRepository {

    private final DataSource dataSource;

    public PostgresqlTypeRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void store(Type type) {
        String sql = "INSERT INTO types (id, name) VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, type.getTypeId().getValue());
            preparedStatement.setString(2, type.getTypeName().toString());

            preparedStatement.execute();

        } catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }
    }

    @Override
    public Optional<Type> get(TypeId typeId) {
        String sql = "SELECT * FROM types WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, typeId.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                TypeDBO typeDBO = TypeDBO.fromResultSet(resultSet);
                Type type = typeDBO.toDomain();
                return Optional.of(type);
            } else {
                return Optional.empty();
            }

        } catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }
    }

    @Override
    public void update(Type type) {
        String sql = "UPDATE types SET name = ? WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, type.getTypeName().toString());
            preparedStatement.setInt(2, type.getTypeId().getValue());

            preparedStatement.execute();

        } catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }
    }

    @Override
    public void delete(TypeId typeId) {
        String sql = "DELETE FROM types WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, typeId.getValue());
            preparedStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }
    }

    @Override
    public List<Type> getTypes(PageQuery pageQuery) {
        // TODO Auto-generated method stub
        return null;
    }

}
