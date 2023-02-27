package com.tanzicai.caimusic.core.untils;

import com.github.ksuid.Ksuid;
import com.github.ksuid.KsuidGenerator;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;
import java.util.function.Supplier;

public class KsuidIdentificationGennerater implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return KsuidGenerator.generate();
    }
}
