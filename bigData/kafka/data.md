
095509554000     095209524000  094F094F4000

  09 55       09 55		  40          00
原始温度    算法温度    采样率		测量阶段

  2389


topic

dockers/24:0a:c4:0f:7c:04（实际mac地址为上传底座的mac）


Definition of an abstract data type. Data types can be primitive types (integer types, floating point types,
boolean, strings, and bytes) or complex types (typed arrays, maps with one key schema and value schema,
and structs that have a fixed set of field names each with an associated value schema). Any type can be specified
as optional, allowing it to be omitted (resulting in null values when it is missing) and can specify a default
value.


@KafkaListener(topics = "mqtt")
    public void mqttListener(ConsumerRecord<?, ?> consumerRecord) {
        Headers headers = consumerRecord.headers();
        Header[] headers1 = headers.toArray();
        for (Header h : headers1) {
            LOGGER.info(h.key() + ":" + Arrays.toString(h.value()));
        }

        Object value = consumerRecord.value();
        JSONObject jsonObject = JSONObject.parseObject(value.toString());
        byte[] payloads = jsonObject.getBytes("payload");

        LOGGER.info("\n mqtt\n\t" + consumerRecord.key()
                + "\n\t" + value
                + "\n\t" + jsonObject.get("payload")
                + "\n\t" + Arrays.toString(payloads));
    }