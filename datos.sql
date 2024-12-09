CREATE OR REPLACE FUNCTION after_insert_venta()
RETURNS TRIGGER AS $$
DECLARE
    fecha TIMESTAMP;
BEGIN
    SELECT fecha_venta INTO fecha FROM venta WHERE id_venta = NEW.id_venta;
    INSERT INTO historial_venta (id_producto, cantidad_vendida, fecha_venta)
    VALUES (NEW.id_producto, NEW.cantidad, fecha);
    UPDATE producto
    SET stock = stock - NEW.cantidad
    WHERE id_producto = NEW.id_producto;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER after_insert_venta
AFTER INSERT ON detalle_venta
FOR EACH ROW
EXECUTE FUNCTION after_insert_venta();


CREATE SEQUENCE IF NOT EXISTS cliente_id_seq;
CREATE SEQUENCE IF NOT EXISTS laboratorio_id_seq;
CREATE SEQUENCE IF NOT EXISTS categoria_id_seq;
CREATE SEQUENCE IF NOT EXISTS producto_id_producto_seq;
CREATE SEQUENCE IF NOT EXISTS venta_id_venta_seq;
CREATE SEQUENCE IF NOT EXISTS detalle_venta_id_detalle_seq;

INSERT INTO cliente (id_cliente, nombre, direccion, telefono, email)
	VALUES
    (1, 'Axl Severich', 'Av. Secundaria 123, La Paz', '45645643', 'axl.severich@example.com');
INSERT INTO laboratorio (id, nombre, ubicacion)
	VALUES (1, 'Laboratorio ABC', 'Ubicación XYZ');
INSERT INTO categoria (id, nombre)
	VALUES (1, 'Categoría Medicamentos');
INSERT INTO producto (
    id_producto, nombre, descripcion, categoria, laboratorio, stock, precio, 
    fecha_vencimiento, numero_lote, fecha_fabricacion, forma_farmaceutica, 
    punto_reorden, eoq, tiempo_entrega, stock_seguridad
) 
	VALUES (
    1, 'Paracetamol', 'Descripción del producto', 1, 1, 100, 50.00, 
    '2025-12-31', 'Lote001', '2023-01-01', 'Tableta', 
    50, 200, 3, 5
);
INSERT INTO venta (id_venta, fecha_venta, id_cliente, metodo_pago, total)
	VALUES (1, '2023-12-09', 1, 'Tarjeta', 150.00);
INSERT INTO detalle_venta (id_detalle, cantidad, precio_unitario, id_producto, id_venta)
	VALUES (1, 2, 15.00, 1, 1);
	
ALTER TABLE cliente ALTER COLUMN id_cliente SET DEFAULT nextval('cliente_id_seq');
ALTER TABLE laboratorio ALTER COLUMN id SET DEFAULT nextval('laboratorio_id_seq');
ALTER TABLE categoria ALTER COLUMN id SET DEFAULT nextval('categoria_id_seq');
ALTER TABLE producto ALTER COLUMN id_producto SET DEFAULT nextval('producto_id_producto_seq');
ALTER TABLE venta ALTER COLUMN id_venta SET DEFAULT nextval('venta_id_venta_seq');
ALTER TABLE detalle_venta ALTER COLUMN id_detalle SET DEFAULT nextval('detalle_venta_id_detalle_seq');

SELECT setval('detalle_venta_id_detalle_seq', (SELECT MAX(id_detalle) FROM public.detalle_venta));
SELECT setval('producto_id_producto_seq', (SELECT MAX(id_producto) FROM public.producto));
SELECT setval('cliente_id_cliente_seq', (SELECT MAX(id_cliente) FROM public.cliente));
SELECT setval('categoria_id_seq', (SELECT MAX(id) FROM public.categoria));
SELECT setval('laboratorio_id_seq', (SELECT MAX(id) FROM public.laboratorio));
SELECT setval('venta_id_venta_seq', (SELECT MAX(id_venta) FROM public.venta));

INSERT INTO cliente (id_cliente, nombre, direccion, telefono, email)
VALUES
    (nextval('cliente_id_seq'), 'Diego Huayta', 'Av. Principal 123, La Paz', '123456789', 'diego.huayta@example.com'),
    (nextval('cliente_id_seq'), 'Juan Pérez', 'Calle Falsa 456, Cochabamba', '987654321', 'juan.perez@example.com'),
    (nextval('cliente_id_seq'), 'María González', 'Calle Real 789, Santa Cruz', '456789123', 'maria.gonzalez@example.com'),
    (nextval('cliente_id_seq'), 'Carlos Méndez', 'Av. El Sol 101, Oruro', '321654987', 'carlos.mendez@example.com');


INSERT INTO laboratorio (id, nombre, ubicacion)
VALUES
    (nextval('laboratorio_id_seq'), 'Laboratorio A', 'Ubicación A'),
    (nextval('laboratorio_id_seq'), 'Laboratorio B', 'Ubicación B'),
    (nextval('laboratorio_id_seq'), 'Laboratorio C', 'Ubicación C'),
    (nextval('laboratorio_id_seq'), 'Laboratorio D', 'Ubicación D'),
    (nextval('laboratorio_id_seq'), 'Laboratorio E', 'Ubicación E'),
    (nextval('laboratorio_id_seq'), 'Laboratorio F', 'Ubicación F'),
    (nextval('laboratorio_id_seq'), 'Laboratorio G', 'Ubicación G'),
    (nextval('laboratorio_id_seq'), 'Laboratorio H', 'Ubicación H'),
    (nextval('laboratorio_id_seq'), 'Laboratorio I', 'Ubicación I'),
    (nextval('laboratorio_id_seq'), 'Laboratorio J', 'Ubicación J'),
    (nextval('laboratorio_id_seq'), 'Laboratorio K', 'Ubicación K'),
    (nextval('laboratorio_id_seq'), 'Laboratorio L', 'Ubicación L'),
    (nextval('laboratorio_id_seq'), 'Laboratorio M', 'Ubicación M'),
    (nextval('laboratorio_id_seq'), 'Laboratorio N', 'Ubicación N'),
    (nextval('laboratorio_id_seq'), 'Laboratorio O', 'Ubicación O'),
    (nextval('laboratorio_id_seq'), 'Laboratorio P', 'Ubicación P'),
    (nextval('laboratorio_id_seq'), 'Laboratorio Q', 'Ubicación Q'),
    (nextval('laboratorio_id_seq'), 'Laboratorio R', 'Ubicación R'),
    (nextval('laboratorio_id_seq'), 'Laboratorio S', 'Ubicación S'),
    (nextval('laboratorio_id_seq'), 'Laboratorio T', 'Ubicación T'),
    (nextval('laboratorio_id_seq'), 'Laboratorio U', 'Ubicación U'),
    (nextval('laboratorio_id_seq'), 'Laboratorio V', 'Ubicación V'),
    (nextval('laboratorio_id_seq'), 'Laboratorio W', 'Ubicación W'),
    (nextval('laboratorio_id_seq'), 'Laboratorio X', 'Ubicación X');

INSERT INTO categoria (id, nombre)
VALUES
    (nextval('categoria_id_seq'), 'Analgésicos'),
    (nextval('categoria_id_seq'), 'Antiinflamatorios'),
    (nextval('categoria_id_seq'), 'Antibióticos'),
    (nextval('categoria_id_seq'), 'Alergias'),
    (nextval('categoria_id_seq'), 'Gastrointestinales'),
    (nextval('categoria_id_seq'), 'Vitaminas y Minerales'),
    (nextval('categoria_id_seq'), 'Medicamentos para Diabetes'),
    (nextval('categoria_id_seq'), 'Hormonas');

INSERT INTO producto (
    id_producto, nombre, descripcion, categoria, laboratorio, stock, precio, 
    fecha_vencimiento, numero_lote, fecha_fabricacion, forma_farmaceutica, 
    punto_reorden, eoq, tiempo_entrega, stock_seguridad
) 
VALUES
    (nextval('producto_id_producto_seq'),'Paracetamol 500mg', 'Analgésico y antipirético', 'Analgésicos', 'Laboratorio A', 100, 1.50, '2025-12-31', 'LOTE123', '2024-07-05', 'Tabletas', 20, 50, 7, 5),
    (nextval('producto_id_producto_seq'),'Ibuprofeno 400mg', 'Antiinflamatorio no esteroideo', 'Antiinflamatorios', 'Laboratorio B', 80, 2.00, '2025-11-15', 'LOTE456', '2024-06-20', 'Cápsulas', 15, 40, 7, 5),
    (nextval('producto_id_producto_seq'),'Amoxicilina 500mg', 'Antibiótico', 'Antibióticos', 'Laboratorio C', 50, 3.50, '2025-08-30', 'LOTE789', '2024-05-10', 'Tabletas', 10, 30, 7, 5),
    (nextval('producto_id_producto_seq'),'Diclofenaco 50mg', 'Antiinflamatorio no esteroideo', 'Antiinflamatorios', 'Laboratorio D', 70, 2.50, '2025-10-20', 'LOTE101', '2024-06-15', 'Gel', 12, 35, 7, 5),
    (nextval('producto_id_producto_seq'),'Loratadina 10mg', 'Antihistamínico', 'Alergias', 'Laboratorio E', 90, 1.80, '2026-01-15', 'LOTE111', '2024-07-10', 'Tabletas', 18, 45, 7, 5),
    (nextval('producto_id_producto_seq'),'Omeprazol 20mg', 'Antiácido', 'Gastrointestinales', 'Laboratorio F', 60, 2.20, '2025-12-10', 'LOTE121', '2024-06-25', 'Cápsulas', 10, 30, 7, 5),
    (nextval('producto_id_producto_seq'),'Vitamina C 500mg', 'Vitaminas y Minerales', 'Suplementos', 'Laboratorio G', 120, 1.00, '2026-03-31', 'LOTE131', '2024-08-01', 'Tabletas efervescentes', 25, 60, 7, 5),
    (nextval('producto_id_producto_seq'),'Calcio 600mg', 'Vitaminas y Minerales', 'Suplementos', 'Laboratorio H', 80, 1.50, '2026-02-28', 'LOTE141', '2024-07-20', 'Tabletas', 15, 40, 7, 5),
    (nextval('producto_id_producto_seq'),'Insulina NPH', 'Diabetes', 'Medicamentos para Diabetes', 'Laboratorio I', 30, 15.00, '2025-09-30', 'LOTE151', '2024-05-15', 'Inyectable', 5, 20, 7, 5),
    (nextval('producto_id_producto_seq'),'Metformina 500mg', 'Diabetes', 'Medicamentos para Diabetes', 'Laboratorio J', 40, 1.80, '2025-11-10', 'LOTE161', '2024-06-05', 'Tabletas', 8, 25, 7, 5),
    (nextval('producto_id_producto_seq'),'Claritromicina 500mg', 'Antibiótico', 'Antibióticos', 'Laboratorio K', 25, 4.00, '2025-10-15', 'LOTE171', '2024-05-20', 'Tabletas', 5, 15, 7, 5),
    (nextval('producto_id_producto_seq'),'Azitromicina 500mg', 'Antibiótico', 'Antibióticos', 'Laboratorio L', 35, 3.80, '2025-12-20', 'LOTE181', '2024-06-10', 'Tabletas', 7, 20, 7, 5),
    (nextval('producto_id_producto_seq'),'Ciprofloxacino 500mg', 'Antibiótico', 'Antibióticos', 'Laboratorio M', 20, 4.50, '2025-11-30', 'LOTE191', '2024-05-25', 'Tabletas', 4, 12, 7, 5),
    (nextval('producto_id_producto_seq'),'Prednisona 20mg', 'Corticosteroides', 'Hormonas', 'Laboratorio N', 15, 3.00, '2025-10-05', 'LOTE201', '2024-06-01', 'Tabletas', 3, 10, 7, 5),
    (nextval('producto_id_producto_seq'),'Levotiroxina 100mcg', 'Hormonas', 'Hormonas', 'Laboratorio O', 45, 2.80, '2026-01-10', 'LOTE211', '2024-07-05', 'Tabletas', 9, 25, 7, 5),
    (nextval('producto_id_producto_seq'),'Ranitidina 150mg', 'Antiácido', 'Gastrointestinales', 'Laboratorio P', 55, 1.90, '2025-12-15', 'LOTE221', '2024-06-20', 'Tabletas', 10, 30, 7, 5),
    (nextval('producto_id_producto_seq'),'Paracetamol infantil 120mg', 'Analgésico y antipirético infantil', 'Analgésicos', 'Laboratorio Q', 150, 1.20, '2026-04-30', 'LOTE231', '2024-08-15', 'Jarabe', 30, 70, 7, 5),
    (nextval('producto_id_producto_seq'),'Ibuprofeno infantil 100mg', 'Antiinflamatorio no esteroideo infantil', 'Antiinflamatorios', 'Laboratorio R', 120, 1.00, '2026-03-25', 'LOTE241', '2024-07-20', 'Suspensión', 25, 60, 7, 5),
    (nextval('producto_id_producto_seq'),'Amoxicilina suspensión oral', 'Antibiótico infantil', 'Antibióticos', 'Laboratorio S', 80, 2.50, '2025-12-10', 'LOTE251', '2024-06-05', 'Suspensión', 15, 40, 7, 5),
    (nextval('producto_id_producto_seq'),'Naproxeno 500mg', 'Antiinflamatorio no esteroideo', 'Antiinflamatorios', 'Laboratorio T', 70, 2.80, '2025-11-20', 'LOTE261', '2024-06-15', 'Cápsulas', 12, 35, 7, 5),
    (nextval('producto_id_producto_seq'),'Cetirizina 10mg', 'Antihistamínico', 'Alergias', 'Laboratorio U', 90, 1.60, '2026-02-15', 'LOTE271', '2024-07-10', 'Tabletas', 18, 45, 7, 5),
    (nextval('producto_id_producto_seq'),'Pantoprazol 40mg', 'Antiácido', 'Gastrointestinales', 'Laboratorio V', 60, 2.40, '2026-01-10', 'LOTE281', '2024-06-25', 'Cápsulas', 10, 30, 7, 5),
    (nextval('producto_id_producto_seq'),'Vitamina D3 400 UI', 'Vitaminas y Minerales', 'Suplementos', 'Laboratorio W', 120, 1.10, '2026-05-31', 'LOTE291', '2024-08-01', 'Gotas', 25, 60, 7, 5),
    (nextval('producto_id_producto_seq'),'Magnesio 250mg', 'Vitaminas y Minerales', 'Suplementos', 'Laboratorio X', 80, 1.40, '2026-04-28', 'LOTE301', '2024-07-20', 'Tabletas masticables', 25, 60, 7, 5);

INSERT INTO venta (id_venta, fecha_venta, id_cliente, metodo_pago, total) 
VALUES
	(nextval('venta_id_venta_seq'), '2023-01-15', 1, 'Transferencia', 150.00),
	(nextval('venta_id_venta_seq'), '2023-02-10', 2, 'Efectivo', 180.00),
	(nextval('venta_id_venta_seq'), '2023-03-22', 3, 'Tarjeta', 210.00),
	(nextval('venta_id_venta_seq'), '2023-04-17', 4, 'Transferencia', 250.00),
	(nextval('venta_id_venta_seq'), '2024-01-05', 1, 'Efectivo', 300.00),
	(nextval('venta_id_venta_seq'), '2024-02-15', 2, 'Tarjeta', 230.00),
	(nextval('venta_id_venta_seq'), '2024-03-08', 3, 'Transferencia', 190.00),
	(nextval('venta_id_venta_seq'), '2024-04-20', 4, 'Efectivo', 350.00),
	(nextval('venta_id_venta_seq'), '2024-05-02', 1, 'Tarjeta', 400.00),
	(nextval('venta_id_venta_seq'), '2024-06-10', 2, 'Transferencia', 280.00),
	(nextval('venta_id_venta_seq'), '2024-07-13', 3, 'Efectivo', 250.00),
	(nextval('venta_id_venta_seq'), '2024-08-25', 4, 'Tarjeta', 310.00),
	(nextval('venta_id_venta_seq'), '2024-09-15', 1, 'Transferencia', 420.00),
	(nextval('venta_id_venta_seq'), '2024-10-22', 2, 'Efectivo', 230.00),
	(nextval('venta_id_venta_seq'), '2024-11-05', 3, 'Tarjeta', 350.00),
	(nextval('venta_id_venta_seq'), '2024-12-01', 4, 'Transferencia', 380.00);


INSERT INTO detalle_venta (id_detalle, cantidad, precio_unitario, id_producto, id_venta)
VALUES
    (nextval('detalle_venta_id_detalle_seq'), 3, 15.00, 2, 1),
    (nextval('detalle_venta_id_detalle_seq'), 2, 20.50, 3, 1),
    (nextval('detalle_venta_id_detalle_seq'), 4, 10.00, 4, 1),
    (nextval('detalle_venta_id_detalle_seq'), 5, 30.00, 5, 1),
    (nextval('detalle_venta_id_detalle_seq'), 3, 15.00, 6, 2),
    (nextval('detalle_venta_id_detalle_seq'), 1, 25.00, 7, 2),
    (nextval('detalle_venta_id_detalle_seq'), 2, 18.50, 8, 2),
    (nextval('detalle_venta_id_detalle_seq'), 4, 22.50, 9, 2),
    (nextval('detalle_venta_id_detalle_seq'), 3, 14.00, 10, 3),
    (nextval('detalle_venta_id_detalle_seq'), 2, 20.00, 11, 3),
    (nextval('detalle_venta_id_detalle_seq'), 1, 25.00, 12, 3),
    (nextval('detalle_venta_id_detalle_seq'), 4, 18.50, 13, 3),
    (nextval('detalle_venta_id_detalle_seq'), 5, 12.00, 14, 4),
    (nextval('detalle_venta_id_detalle_seq'), 3, 28.00, 15, 4),
    (nextval('detalle_venta_id_detalle_seq'), 2, 19.00, 16, 4),
    (nextval('detalle_venta_id_detalle_seq'), 4, 30.00, 17, 4),
    (nextval('detalle_venta_id_detalle_seq'), 2, 18.50, 18, 5),
    (nextval('detalle_venta_id_detalle_seq'), 4, 25.00, 19, 5),
    (nextval('detalle_venta_id_detalle_seq'), 1, 22.00, 20, 5),
    (nextval('detalle_venta_id_detalle_seq'), 3, 15.00, 21, 5),
    (nextval('detalle_venta_id_detalle_seq'), 2, 17.50, 22, 6),
    (nextval('detalle_venta_id_detalle_seq'), 5, 12.50, 23, 6),
    (nextval('detalle_venta_id_detalle_seq'), 3, 19.00, 24, 6),
    (nextval('detalle_venta_id_detalle_seq'), 4, 14.00, 25, 6),
    (nextval('detalle_venta_id_detalle_seq'), 2, 21.50, 2, 7),
    (nextval('detalle_venta_id_detalle_seq'), 4, 30.00, 3, 7),
    (nextval('detalle_venta_id_detalle_seq'), 1, 25.50, 4, 7),
    (nextval('detalle_venta_id_detalle_seq'), 3, 18.00, 5, 7),
    (nextval('detalle_venta_id_detalle_seq'), 3, 20.00, 6, 8),
    (nextval('detalle_venta_id_detalle_seq'), 2, 28.00, 7, 8),
    (nextval('detalle_venta_id_detalle_seq'), 4, 16.50, 8, 8),
    (nextval('detalle_venta_id_detalle_seq'), 5, 22.00, 9, 8),
    (nextval('detalle_venta_id_detalle_seq'), 2, 18.00, 10, 9),
    (nextval('detalle_venta_id_detalle_seq'), 3, 12.00, 11, 9),
    (nextval('detalle_venta_id_detalle_seq'), 1, 30.00, 12, 9),
    (nextval('detalle_venta_id_detalle_seq'), 2, 25.00, 13, 9),
    (nextval('detalle_venta_id_detalle_seq'), 3, 22.00, 14, 10),
    (nextval('detalle_venta_id_detalle_seq'), 1, 25.00, 15, 10),
    (nextval('detalle_venta_id_detalle_seq'), 4, 18.00, 16, 10),
    (nextval('detalle_venta_id_detalle_seq'), 2, 12.50, 17, 10);
