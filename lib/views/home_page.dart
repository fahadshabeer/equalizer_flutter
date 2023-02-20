import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class Homepage extends StatelessWidget {
  const Homepage({Key? key}) : super(key: key);
  static const platform = MethodChannel('example.com/channel');

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: Container(
        child: Center(
          child: MaterialButton(
            onPressed: ()async{
             
                try {
                await platform.invokeMethod('change');
                } on PlatformException catch (e) {
                 print(e);
                }
            },
            child: Text("open"),
          ),
        ),
      ),
    );
  }
}
