## 1 获取当前最新的区块



url:block/getrecentblocks

method：GET

response：
```json
[
    {
        "blockhash": "000000000000000000051ce97582f22c3f24de4884eb5ee7ca98efd563879dba",
        "height": 580678,
        "time": "1560566903190",
        "transactions": 2564,
        "miner": "F2Pool",
        "size": 1143.45
    },
    {
        "blockhash": "00000000000000000011903ce43dad868af043ca2f967016b4a2ba16e5311e53",
        "height": 580673,
        "time": "1560566903190",
        "transactions": 2688,
        "miner": "ViaBTC",
        "size": 1069.494
    }
]
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块hash |
|    height|   Integer |  区块高度 |
|    time|  String |  出块时间 |
|    transactions|   交易总数量 |
|    miner|   String |  矿工 |
|    size|   Float |  大小 |


## 2 获取按照块hash查找



url:/block/getByBlockhash?blockhash={blockhash}

method：GET

response：
```json
{
    "blockhash": "00000000000000000011903ce43dad868af043ca2f967016b4a2ba16e5311e53",
    "height": 580673,
    "time": "1560566903190",
    "transactions": 2688,
    "miner": "ViaBTC",
    "size": 1069.494,
    "outputtotal": 1692.9792,
    "merkleroot": "e4ef6b371d290b2715d53f09315839d79f30c58837083bba2d07eb53576dc2bc",
    "estimated": 215.7849,
    "fees": 0.22123845,
    "difficulty": 7409399249090.25,
    "weight": 1,
    "bits": 388365568,
    "version": "0x20000000",
    "nonce": 394583144,
    "nextBlock": "0000000000000000001aa40e06ed3978a028fd3b4bdf7e1b882d1c827991b096",
    "prevBlock": "0000000000000000001d05f0e7621183f88c452401fb8d180ba49fdd75c5b44e",
    "blockreward": 12.5
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块hash |
|    height|   Integer |  区块高度 |
|    time|  String |  出块时间 |
|    transactions|   交易总数量 |
|    miner|   String |  矿工 |
|    size|   Float |  大小 |
|    outputtotal|   Float |  全部交易量 |
|    merkleroot|   String |  树根 |
|    estimated|   Float |  预计交易量 |
|    fees|   Float |  交易费用 |
|    difficulty|   Double |  难度系数 |
|    weight|   Float |  重量 |
|    bits|   Float |  位 |
|    version|   String |  版本 |
|    nonce|   Integer |  实时标志 |
|    nextBlock|   String |  下一个块hash' |
|    prevBlock|   String |  上一个块hash |
|    blockreward|   Float |  块奖励 |



## 3 获取按照块高度查找



url:/block/getByBlockhash?blockheight={blockheight}

method：GET

response：
```json
{
    "blockhash": "00000000000000000011903ce43dad868af043ca2f967016b4a2ba16e5311e53",
    "height": 580673,
    "time": "1560566903190",
    "transactions": 2688,
    "miner": "ViaBTC",
    "size": 1069.494,
    "outputtotal": 1692.9792,
    "merkleroot": "e4ef6b371d290b2715d53f09315839d79f30c58837083bba2d07eb53576dc2bc",
    "estimated": 215.7849,
    "fees": 0.22123845,
    "difficulty": 7409399249090.25,
    "weight": 1,
    "bits": 388365568,
    "version": "0x20000000",
    "nonce": 394583144,
    "nextBlock": "0000000000000000001aa40e06ed3978a028fd3b4bdf7e1b882d1c827991b096",
    "prevBlock": "0000000000000000001d05f0e7621183f88c452401fb8d180ba49fdd75c5b44e",
    "blockreward": 12.5
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块hash |
|    height|   Integer |  区块高度 |
|    time|  String |  出块时间 |
|    transactions|   交易总数量 |
|    miner|   String |  矿工 |
|    size|   Float |  大小 |
|    outputtotal|   Float |  全部交易量 |
|    merkleroot|   String |  树根 |
|    estimated|   Float |  预计交易量 |
|    fees|   Float |  交易费用 |
|    difficulty|   Double |  难度系数 |
|    weight|   Float |  重量 |
|    bits|   Float |  位 |
|    version|   String |  版本 |
|    nonce|   Integer |  实时标志 |
|    nextBlock|   String |  下一个块hash' |
|    prevBlock|   String |  上一个块hash |
|    blockreward|   Float |  块奖励 |