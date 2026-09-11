const appDb = db.getSiblingDB("demo-docker");

appDb.customer.insertMany([
    {
        _id: "customer-001",
        firstName: "John",
        lastName: "Smith"
    },
    {
        _id: "customer-002",
        firstName: "Alice",
        lastName: "Brown"
    },
    {
        _id: "customer-003",
        firstName: "Jane",
        lastName: "Smith"
    },
    {
        _id: "customer-004",
        firstName: "Bob",
        lastName: "Johnson"
    },
    {
        _id: "customer-005",
        firstName: "Anna",
        lastName: "Williams"
    }
]);

appDb.order.insertMany([
    {
        _id: "order-001",
        desc: "Laptop order",
        customer: DBRef("customer", "customer-001")
    },
    {
        _id: "order-002",
        desc: "Monitor order",
        customer: DBRef("customer", "customer-001")
    },
    {
        _id: "order-003",
        desc: "Keyboard order",
        customer: DBRef("customer", "customer-001")
    },
    {
        _id: "order-004",
        desc: "Office chair order",
        customer: DBRef("customer", "customer-002")
    },
    {
        _id: "order-005",
        desc: "Desk order",
        customer: DBRef("customer", "customer-002")
    },
    {
        _id: "order-006",
        desc: "Headphones order",
        customer: DBRef("customer", "customer-002")
    },
    {
        _id: "order-007",
        desc: "Smartphone order",
        customer: DBRef("customer", "customer-003")
    },
    {
        _id: "order-008",
        desc: "Tablet order",
        customer: DBRef("customer", "customer-003")
    },
    {
        _id: "order-009",
        desc: "USB cable order",
        customer: DBRef("customer", "customer-003")
    },
    {
        _id: "order-010",
        desc: "Printer order",
        customer: DBRef("customer", "customer-004")
    },
    {
        _id: "order-011",
        desc: "Scanner order",
        customer: DBRef("customer", "customer-004")
    },
    {
        _id: "order-012",
        desc: "Web camera order",
        customer: DBRef("customer", "customer-004")
    },
    {
        _id: "order-013",
        desc: "Mouse order",
        customer: DBRef("customer", "customer-005")
    },
    {
        _id: "order-014",
        desc: "External SSD order",
        customer: DBRef("customer", "customer-005")
    },
    {
        _id: "order-015",
        desc: "Docking station order",
        customer: DBRef("customer", "customer-005")
    }
]);